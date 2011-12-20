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
@SuppressWarnings("serial")
@Entity
@Table(name="ADDRESS")
public class Address extends BaseDomain{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private Long addressId;
	
	@Column(name="ADDRESS_TYPE")
	private Long addressType;
	
	@Column(name="HNO")
	private String hNo;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="COUNTRY")
	private String country;
	
	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getAddressType() {
		return addressType;
	}

	public void setAddressType(Long addressType) {
		this.addressType = addressType;
	}

	public String getHNo() {
		return hNo;
	}

	public void setHNo(String no) {
		hNo = no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
