package com.simian.medallion.mobile.service;


import java.util.List;

import com.simian.medallion.mobile.json.NavJson;
import com.simian.medallion.mobile.json.ProductJson;
import com.simian.medallion.mobile.model.Chart;
import com.simian.medallion.mobile.model.Nav;
import com.simian.medallion.mobile.model.User;
import com.simian.medallion.mobile.model.parameter.Parameter;
import com.simian.medallion.mobile.model.parameter.ParameterChart;

/**
 * Ini adalah service yang di gunakan oleh MobileController dimana method yang di panggil
 * hanya melayani rest call
 */

public interface MobileService {
	
	
	/****************************** USER ******************************/
	public User findByUsername(String username);
	public void updateUser(User user);
	
	
	
	/****************************** PRODUCT ******************************/
	public List<ProductJson> getProducts(Parameter param);
	
	
	
    /****************************** NAV ******************************/
	public List<NavJson> getNavs(Parameter param);
	public NavJson saveNav(Nav nav);
	public List<Chart> chartNav(ParameterChart param);
}