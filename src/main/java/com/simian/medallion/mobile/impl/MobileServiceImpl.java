package com.simian.medallion.mobile.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.simian.medallion.mobile.json.Cleaner;
import com.simian.medallion.mobile.json.NavJson;
import com.simian.medallion.mobile.json.ProductJson;
import com.simian.medallion.mobile.model.Chart;
import com.simian.medallion.mobile.model.Nav;
import com.simian.medallion.mobile.model.Product;
import com.simian.medallion.mobile.model.Series;
import com.simian.medallion.mobile.model.User;
import com.simian.medallion.mobile.model.parameter.Parameter;
import com.simian.medallion.mobile.model.parameter.ParameterChart;
import com.simian.medallion.mobile.service.MobileService;

@Service
public class MobileServiceImpl extends DaoImpl implements MobileService {
	private Logger log = LoggerFactory.getLogger(MobileServiceImpl.class);

	
	/****************************** USER ******************************/
	@Override
	@Transactional(propagation = Propagation.SUPPORTS) 
    public User findByUsername(String username) {
    	log.debug("findByUsername username="+username);
    	
    	User user = userRepo.getUser(username);
    	if (user == null) return user;
    	
//    	Role role = new Role();
//    	role.setName("ROLE_TRUSTED_CLIENT");
//    	user.getRoles().add(role);
    	
    	return user;
    }
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED) 
	public void updateUser(User user) {
		log.debug("updateUser user="+user);
		
		userRepo.updateUser(user.getUsername(), user.isRememberme());
	}
	
	
	
	/****************************** USER ******************************/
	@Override
	@Transactional(propagation = Propagation.SUPPORTS) 
    public List<ProductJson> getProducts(Parameter param) {
    	log.debug("getProducts param="+param);
    	
    	return Cleaner.productClean(productRepo.getProducts(param.getCode()));
    }
	
	
	
    /****************************** NAV ******************************/
	@Override
	@Transactional(propagation = Propagation.SUPPORTS) 
    public List<NavJson> getNavs(Parameter param) {
    	log.debug("getNavs param="+param);
    	
    	return Cleaner.navClean(navRepo.getNavs(param.getId(), param.getFromDate(), param.getToDate()));
    }
    
	@Override
	@Transactional(propagation = Propagation.REQUIRED) 
    public NavJson saveNav(Nav nav) {
    	log.debug("saveNav nav="+nav);
    	
    	Product product = productRepo.getProduct(nav.getProduct().getId());
    	if (product.getLastDate().compareTo(nav.getDate()) < 0) {
    		product.setLastDate(nav.getDate());
    	}
    	
    	return Cleaner.clean(navRepo.save(nav));
    }
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Chart> chartNav(ParameterChart param) {
		List<Nav> navs = navRepo.getChartNav(param.getIds(), param.getFromDate(), param.getToDate());
		
		Map<String, Chart> charts = new HashMap<String, Chart>();
		for (Long id : param.getIds()) {
			Product product = productRepo.getProduct(id);
			charts.put(product.getCode(), new Chart(product.getCode()));  
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		for (Nav nav : navs) {
			Chart chart = charts.get(nav.getProduct().getCode());
			chart.getSeries().add(new Series(sdf.format(nav.getDate()), nav.getPrice(), nav.getVolume()));
		}
	
		return new ArrayList(charts.values());
	}
}
