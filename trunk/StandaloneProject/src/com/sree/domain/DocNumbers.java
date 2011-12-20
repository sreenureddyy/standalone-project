/**
 * 
 */
package com.sree.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author srinivasr
 * 
 */
@Entity
@Table(name="DOC_NUMBERS")
public class DocNumbers extends BaseDomain{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DOC_NUM_ID")
	private Long docNumId;
	
	@Column(name="DOC_TYPE")
	private String docType;
	
	@Column(name="DESCRIPTION", length=100)
	private String description;
	
	@Column(name="PREFIX", length=10)
	private String prefix;
	
	@Column(name="SUFFIX", length=10)
	private String suffix;
	
	@Column(name="PADDED_LENGTH", scale=10)
	private Integer paddedLength;
	
	@Column(name="ACTIVE")
	private Boolean active = true;
	
	@Column(name="CURRENT_NUMBER")
	private Long currentNumber;

	public Long getDocNumId() {
		return docNumId;
	}

	public void setDocNumId(Long docNumId) {
		this.docNumId = docNumId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Integer getPaddedLength() {
		return paddedLength;
	}

	public void setPaddedLength(Integer paddedLength) {
		this.paddedLength = paddedLength;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(Long currentNumber) {
		this.currentNumber = currentNumber;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}
}
