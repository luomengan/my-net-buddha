package com.luomengan.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 安全认证 工具类
 * 
 * @author luomengan
 *
 */
public class SecurityUtil {

	public static CustomUserDetails getUserDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object details = authentication.getDetails();
		if (details != null && details instanceof CustomUserDetails) {
			return (CustomUserDetails) details;
		}
		return null;
	}

	public static Integer getUserId() {
		CustomUserDetails details = getUserDetails();
		if (details != null) {
			return details.getUserId();
		} else {
			return 0;
		}
	}

}
