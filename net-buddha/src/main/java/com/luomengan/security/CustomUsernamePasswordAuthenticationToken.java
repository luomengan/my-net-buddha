package com.luomengan.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -3969104903599527222L;

	private boolean isAdmin;

	public CustomUsernamePasswordAuthenticationToken(Object principal, Object credentials, boolean isAdmin) {
		super(principal, credentials);
		this.isAdmin = isAdmin;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
