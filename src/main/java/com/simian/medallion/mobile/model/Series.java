package com.simian.medallion.mobile.model;

import java.io.Serializable;

public class Series implements Serializable{
	private static final long serialVersionUID = -894762188258502204L;
	
	private Object d; // Date : Horizontal in chart 
	private Object p; // Price : Vertical in chart
	private Object v; // Volume : Vertical in chart
	
	public Series(Object d, Object p, Object v) {
		this.d = d;
		this.p = p;
		this.v = v;
	}

	public Object getD() { return d; }
	public void setD(Object d) { this.d = d; }

	public Object getP() { return p; }
	public void setP(Object p) { this.p = p; }

	public Object getV() { return v; }
	public void setV(Object v) { this.v = v; }
}