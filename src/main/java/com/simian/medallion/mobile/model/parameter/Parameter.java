package com.simian.medallion.mobile.model.parameter;

import java.io.Serializable;
import java.util.Date;

public class Parameter implements Serializable{
	private static final long serialVersionUID = 377427326662275094L;
	
	private Long id;
	private String code;
	private Date fromDate;
	private Date toDate;
	
	public Parameter() {}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getCode() { return code; }
	public void setCode(String code) { this.code = code; }

	public Date getFromDate() { return fromDate; }
	public void setFromDate(Date fromDate) { this.fromDate = fromDate; }
	
	public Date getToDate() { return toDate; }
	public void setToDate(Date toDate) { this.toDate = toDate; }

	@Override
	public String toString() {
		return "Parameter [id=" + id + ", code=" + code + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
}