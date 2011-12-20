/**
 * 
 */
package com.sree.exam;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sree.domain.BaseDomain;

/**
 * @author srinivasr
 *
 */
@SuppressWarnings("serial")
public class Author extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AUTHOR_ID")
	private Long id;
	
	private String name;
	
	private String status;
	
	private Date dob = new Date();
	
	private Date dod = new Date();
	
	private String biography;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDod() {
		return dod;
	}

	public void setDod(Date dod) {
		this.dod = dod;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
}
