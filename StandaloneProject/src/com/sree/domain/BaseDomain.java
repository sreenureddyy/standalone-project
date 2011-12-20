package com.sree.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public class BaseDomain implements Serializable {
	@Column(name="CREATED_DATE")
	private Date cretedDate = new Date();
	
	@Column(name="CREATED_USER")
	private String createdUser;
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate = new Date();
	
	@Column(name="UPDATED_USER")
	private String updatedUser;
	
	public Date getCretedDate() {
		return cretedDate;
	}
	public void setCretedDate(Date cretedDate) {
		this.cretedDate = cretedDate;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedUser() {
		return updatedUser;
	}
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
}
