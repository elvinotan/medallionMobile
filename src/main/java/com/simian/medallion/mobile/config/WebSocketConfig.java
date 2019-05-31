package com.simian.medallion.mobile.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.simian.medallion.mobile.service.WebsocketService;

/*
 * Websocket configuration class, dimana saat ini menggunakan path /websocket
 * harus di sertakan .setAllowedOrigins("*"). kalo tidak tidak bisa di access
 */

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	
	// ws://localhost:8080/medallionSalesMobile/websocket
	// websocket memungkinkan menggunkan aouth2 dengan cara
	// ws://localhost:8080/medallionSalesMobile/websocket?access_token=b4603b52-0ca5-4cb2-a27c-424f4592dca7
	
	@Autowired
	private WebsocketService websocketService;
	
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new WebSocketHandler(websocketService), "/websocket").setAllowedOrigins("*");
	}
}