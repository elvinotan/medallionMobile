package com.simian.medallion.mobile.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simian.medallion.mobile.json.NavJson;
import com.simian.medallion.mobile.json.ProductJson;
import com.simian.medallion.mobile.model.Chart;
import com.simian.medallion.mobile.model.Nav;
import com.simian.medallion.mobile.model.User;
import com.simian.medallion.mobile.model.parameter.Parameter;
import com.simian.medallion.mobile.model.parameter.ParameterChart;
import com.simian.medallion.mobile.service.MobileService;


@RestController
public class MobileController {
	private Logger log = LoggerFactory.getLogger(MobileController.class);
	
	@Autowired
	private MobileService mobileService;
	
	/*----------------------------------------------------------------------*/
	/* PUBLIC METHOD, all user can access this method						*/
	/*----------------------------------------------------------------------*/

	@PostMapping(value = "/public/nav/list")
    public List<NavJson> publiclistnav(@RequestBody Parameter param){
    	log.debug("publiclistnav param="+param);
    	 
    	return mobileService.getNavs(param);
    }

	
	
	/*----------------------------------------------------------------------*/
	/* PRIVATE METHOD, use must logged in to access this method				*/
	/*----------------------------------------------------------------------*/
	
	@PostMapping(value = "/private/product/list")
    public List<ProductJson> getProducts(@RequestBody Parameter param){
    	log.debug("getProducts param="+param);
    	
    	return mobileService.getProducts(param);
    }
	
	@PostMapping(value = "/private/user/update")
    public void updateUser(@RequestBody User user){
    	log.debug("updateUser user="+user);
    	
    	mobileService.updateUser(user);
    }

	@PostMapping(value = "/private/nav/list")
    public List<NavJson> privatelistnav(@RequestBody Parameter param){
    	log.debug("privatelistnav param="+param);
    	
    	return mobileService.getNavs(param);
    }
    
    @PostMapping(value = "/private/nav/save")
    public NavJson saveNav(@RequestBody Nav nav){
    	log.debug("saveNav nav="+nav);
    	
        return mobileService.saveNav(nav);
    }
    
    @PostMapping(value = "/private/nav/chart")
    public List<Chart> chartNav(@RequestBody ParameterChart param){
    	log.debug("chartNav param="+param);
    	
        return mobileService.chartNav(param);
    }
}
