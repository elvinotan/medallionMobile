package com.simian.medallion.mobile.model;

import java.io.Serializable;
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
@Table(name = "AUSER")
public class User implements Serializable{
	private static final long serialVersionUID = 1264935532091765363L;
	
	private Long id;
    private String username;
    private String password;
    private boolean rememberme;
    private boolean active;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
//  private List<Role> roles = new ArrayList<Role>();
    
	@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SEQ_USER"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)    
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Column(name = "USERNAME", length = 50)
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	@Column(name = "PASSWORD", length = 100)
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	@Column(name = "REMEMBERME")
	public boolean isRememberme() { return rememberme; }
	public void setRememberme(boolean rememberme) { this.rememberme = rememberme; }

	@Column(name = "ACTIVE")
	public boolean isActive() { return active; }
	public void setActive(boolean active) { this.active = active; }
	
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

//	@Transient	
//	public List<Role> getRoles() { return roles; }
//	public void setRoles(List<Role> roles) { this.roles = roles; }
}
