package com.simian.medallion.mobile.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simian.medallion.mobile.json.NavJson;
import com.simian.medallion.mobile.model.parameter.Parameter;
import com.simian.medallion.mobile.service.MobileService;
import com.simian.medallion.mobile.service.WebsocketService;

@Service
public class WebsocketServiceImpl extends DaoImpl implements WebsocketService {
	private Logger log = LoggerFactory.getLogger(WebsocketServiceImpl.class);
	
	@Autowired
	private MobileService mobileService;

	@Override
	public List<NavJson> getNavs(Parameter param) {
		log.debug("getNavs param="+param);
		
		return mobileService.getNavs(param);
	}
}