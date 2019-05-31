package com.simian.medallion.mobile.json;

import java.util.ArrayList;
import java.util.List;

import com.simian.medallion.mobile.model.Nav;
import com.simian.medallion.mobile.model.Product;

public class Cleaner {

	public static List<ProductJson> productClean(List<Product> products) {
		List<ProductJson> jsons = new ArrayList<ProductJson>();
		for (Product product : products) { jsons.add(clean(product)); }
		products.clear();
		return jsons;
	}
	
	public static List<NavJson> navClean(List<Nav> navs) {
		List<NavJson> jsons = new ArrayList<NavJson>();
		for (Nav nav : navs) { jsons.add(clean(nav)); }
		navs.clear();
		return jsons;
	}
	
	public static ProductJson clean(Product product) {
		ProductJson json = new ProductJson();
		json.id = product.getId();
		json.code = product.getCode();
		json.name = product.getName();
		json.urlProspectus = product.getUrlProspectus();
		json.lastNav = product.getLastNav();
		json.lastVolume = product.getLastVolume();
		json.lastDate = product.getLastDate();
		return json;
	}
	
	public static NavJson clean(Nav nav) {
		NavJson json = new NavJson();
		json.id = nav.getId();
		json.date = nav.getDate();
		json.price = nav.getPrice();
		json.volume = nav.getVolume();
		return json;
	}
}
