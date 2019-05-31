package com.simian.medallion.mobile.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable{
	private static final long serialVersionUID = 4535985131085567511L;
	
	private Long id;
	private String code;
	private String name;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private String urlProspectus;
    private BigDecimal lastNav;
    private BigDecimal lastVolume;
    private Date lastDate;
    
	@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SEQ_PRODUCT"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Column(name = "CODE")
	public String getCode() { return code; }
	public void setCode(String code) { this.code = code; }
	
	@Column(name = "NAME")
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Column(name = "CREATED_BY")
	public String getCreatedBy() { return this.createdBy; }
	public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() { return this.createdDate; }
	public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }
	
	@Column(name = "MODIFIED_BY")
	public String getModifiedBy() { return this.modifiedBy; }
	public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE")
	public Date getModifiedDate() { return this.modifiedDate; }
	public void setModifiedDate(Date modifiedDate) { this.modifiedDate = modifiedDate; }
	
	@Column(name = "URL_PROSPECTUS")
	public String getUrlProspectus() { return urlProspectus; }
	public void setUrlProspectus(String urlProspectus) { this.urlProspectus = urlProspectus; }
	
	@Column(name = "LAST_NAV")	
	public BigDecimal getLastNav() { return lastNav; }
	public void setLastNav(BigDecimal lastNav) { this.lastNav = lastNav; }
	
	@Column(name = "LAST_VOLUME")
	public BigDecimal getLastVolume() { return lastVolume; }
	public void setLastVolume(BigDecimal lastVolume) { this.lastVolume = lastVolume; }
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_DATE")
	public Date getLastDate() { return lastDate; }
	public void setLastDate(Date lastDate) { this.lastDate = lastDate; }
}
