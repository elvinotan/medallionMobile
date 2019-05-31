package com.simian.medallion.mobile.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Class ini berfungsi sebagai command dari ui ke server
 * KHUSUS untuk websocket, dimana
 * method : adalah nama method di WebsocketService.java
 * perameter : adalah pair name value parameter untuk method tersebut
 *
 */

public class WebsocketCommand {

	private String method;
	private Map<String, Object> parameter = new HashMap<String, Object>();
	
	public String getMethod() { return method; }
	public void setMethod(String method) { this.method = method; }

	public Map<String, Object> getParameter() { return parameter; }
	public void setParameter(Map<String, Object> parameter) { this.parameter = parameter; }
}
