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

import org.springframework.security.core.GrantedAuthority;

/**
 * @author srinivasr
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="USER_AUTHORITY")
public class UserAuthority implements GrantedAuthority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AUTHORITY_ID")
	private Long id;

	@Column(name="AUTHORITY")
	private String authority;
	/* (non-Javadoc)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
