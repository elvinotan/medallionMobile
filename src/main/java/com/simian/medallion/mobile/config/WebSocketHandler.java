package com.simian.medallion.mobile.config;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.simian.medallion.mobile.service.WebsocketService;

/**
 * Class in menghandle seluruh requst websocket yang masuk 
 * dimana data yang masuk berupa json WebsocketCommand yang kemudian di convert menjadi object
 * lalu object tersebut akan di invoke ke class WebsocketService.java dan akan di kembalikan result object berupa json pula
 */

@Component
public class WebSocketHandler extends TextWebSocketHandler {
	private Logger log = LoggerFactory.getLogger(WebSocketHandler.class);
	
	private Map<String, WebSocketSession> usernameSessions = new HashMap<String, WebSocketSession>();
	
	private WebsocketService websocketService;
	private static Map<String, Method> methods = new HashMap<String, Method>();
	
	private Gson gson = new Gson();
	
	public WebSocketHandler(WebsocketService websocketService) {
		this.websocketService = websocketService;
		
		try {
			Class<?> clazz = WebsocketService.class;
		    for (Method method : clazz.getDeclaredMethods()) {
		    	methods.put(method.getName(), method);
		    }
		}catch(Exception e) { log.error(e.getMessage(), e); }
	}
		
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws InterruptedException, IOException {
		log.debug("handleTextMessage message="+message.getPayload());
		
		WebsocketCommand command = gson.fromJson(message.getPayload(), WebsocketCommand.class);
		
		try {
			Method method = methods.get(command.getMethod());
			Object[] params = new Object[method.getParameters().length];
			for (int i = 0; i < method.getParameters().length; i++) {
				Parameter p = method.getParameters()[i];
				Class parameterClass = p.getType();
				Object param = command.getParameter().get(p.getName());
				params[i] = convert(parameterClass, param);;
			}
		
			Object result = method.invoke(websocketService, params);
			session.sendMessage(new TextMessage(gson.toJson(result)));
		}catch(Exception e) { log.error(e.getMessage(), e); }
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String username = session.getPrincipal().getName();
		usernameSessions.put(username, session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String username = session.getPrincipal().getName();
		usernameSessions.remove(username);
	}
	
	private Object convert(Class parameterClass, Object param) {
		// lakukan conversi disini, selalu menangkan paramterClass, selalu ubah param menjadi tipe parameterClass
		
		return param;
	}
}