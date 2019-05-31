package com.simian.medallion.mobile.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	private Logger log = LoggerFactory.getLogger(WebController.class);
	
	@RequestMapping({"/"})
	public String home(Model model) {
		log.debug("home");
		
		return "home";
	}
	
	@RequestMapping({"/product"})
	public String product(Model model) {
		log.debug("product");
		
		return "product/list";
	}
}
