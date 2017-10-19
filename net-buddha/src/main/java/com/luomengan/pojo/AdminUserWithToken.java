package com.luomengan.pojo;

import com.luomengan.entity.AdminUser;

public class AdminUserWithToken extends AdminUser {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
