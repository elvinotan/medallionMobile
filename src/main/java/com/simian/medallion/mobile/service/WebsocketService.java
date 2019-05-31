package com.simian.medallion.mobile.service;

import java.util.List;

import com.simian.medallion.mobile.json.NavJson;
import com.simian.medallion.mobile.model.Nav;
import com.simian.medallion.mobile.model.parameter.Parameter;

/**
 * Ini adalah service yang di gunakan oleh Websocket dimana method yang di panggil
 * hanya melayani websocket call, 
 * semua method di class ini akan di panggil secara reflection dari WebsocketHandler
 */

public interface WebsocketService {
	
	/****************************** NAV ******************************/
	public List<NavJson> getNavs(Parameter param);
}
