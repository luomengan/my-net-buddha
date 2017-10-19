package com.luomengan.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = -8766788348000173980L;

	private String token;
	private String username;
	private String name;
	private String password;
	private Integer userId;
	private boolean isAdmin;
	private Collection<? extends GrantedAuthority> authorities;

	public CustomUserDetails(Integer userId, String name, String username, String password, boolean isAdmin,
			Collection<? extends GrantedAuthority> authorities) {
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.authorities = authorities;
	}

	public Integer getUserId() {
		if (userId != null) {
			return userId.intValue();
		}
		return 0;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
