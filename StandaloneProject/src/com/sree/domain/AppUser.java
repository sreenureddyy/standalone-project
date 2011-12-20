/**
 * 
 */
package com.sree.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author srinivasr
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "USER")
@NamedQueries( { 
	@NamedQuery(name = "getUsers", query = "select user.id, user.username, user.accountNonExpired from AppUser user") })
public class AppUser extends BaseDomain implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "USER_NAME", nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "ACCOUNT_NON_LOCKED")
	private Boolean accountNonLocked;

	@Column(name = "ACCOUNT_NON_EXPIRED")
	private Boolean accountNonExpired;

	@Column(name = "CREDENTIALS_NON_EXPIRED")
	private Boolean credentialsNonExpired;

	@Column(name = "ENABLED")
	private Boolean enabled;

	@SuppressWarnings("unused")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private List<UserAuthority> userAuthorities = new ArrayList<UserAuthority>();

	@Transient
	private Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	public AppUser() {
		super();
	}

	public AppUser(Long userId, String username, Boolean accountNonExpired) {
		super();
		this.id = userId;
		this.username = username;
		this.accountNonExpired = accountNonExpired;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	/*
	 * @Override public Collection<GrantedAuthority> getAuthorities() { // TODO
	 * Auto-generated method stub return authorities; }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return accountNonExpired;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return accountNonLocked;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return credentialsNonExpired;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		for (UserAuthority userAuthority : userAuthorities) {
			authorities.add(new GrantedAuthorityImpl(userAuthority
					.getAuthority()));
		}
		return authorities;
	}

	public List<UserAuthority> getUserAuthorities() {
		return userAuthorities;
	}

	public void setUserAuthorities(List<UserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
