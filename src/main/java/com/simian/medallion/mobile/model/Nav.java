package com.simian.medallion.mobile.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "NAV")
public class Nav implements Serializable{
	private static final long serialVersionUID = 7746616688245030600L;
	
	private Long id;
	private Date date;
	private BigDecimal price;
	private BigDecimal volume;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Product product;
	
	public Nav() {}
	
	@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SEQ_NAV"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", length = 7)
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }

	@Column(name = "PRICE")	
	public BigDecimal getPrice() { return price; }
	public void setPrice(BigDecimal price) { this.price = price; }
	
	@Column(name = "VOLUME")	
	public BigDecimal getVolume() { return volume; }
	public void setVolume(BigDecimal volume) { this.volume = volume; }

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID")
	public Product getProduct() { return product; }
	public void setProduct(Product product) { this.product = product; }

	@Override
	public String toString() {
		return "Nav [id=" + id + ", date=" + date + ", price=" + price + ", volume=" + volume + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate="
				+ modifiedDate + ", product=" + product + "]";
	}
	
	
}
