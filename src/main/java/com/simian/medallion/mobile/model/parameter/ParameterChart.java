package com.simian.medallion.mobile.model.parameter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ParameterChart implements Serializable{
	private static final long serialVersionUID = -8012628336806941450L;
	
	public static final String TYPE_DAILY = "DAILY";
	public static final String TYPE_WEEKLY = "WEEKLY";
	public static final String TYPE_MONTHLY = "MONTHLY";
	public static final String TYPE_3_MONTHLY = "3_MONTHLY";
	public static final String TYPE_6_MONTHLY = "6_MONTHLY";
	public static final String TYPE_YEARLY = "YEARLY";
	
	private List<Long> ids;
	private String type;
	private Date fromDate;
	private Date toDate;
	
	public List<Long> getIds() { return ids; }
	public void setIds(List<Long> ids) { this.ids = ids; }
	
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	
	public Date getFromDate() { return fromDate; }
	public void setFromDate(Date fromDate) { this.fromDate = fromDate; }
	
	public Date getToDate() { return toDate; }
	public void setToDate(Date toDate) { this.toDate = toDate; }
}
