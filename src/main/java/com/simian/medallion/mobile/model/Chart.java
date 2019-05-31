package com.simian.medallion.mobile.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Chart implements Serializable{
	private static final long serialVersionUID = -4295996992734457688L;
	
	private String id;
	private List<Series> series = new ArrayList<Series>();
	
	public Chart(String id) {
		this.id = id;
	}
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public List<Series> getSeries() { return series; }
	public void setSeries(List<Series> series) { this.series = series; }
}
