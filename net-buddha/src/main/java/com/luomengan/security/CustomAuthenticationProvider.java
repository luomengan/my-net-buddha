package com.luomengan.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.luomengan.dao.AdminUserDao;
import com.luomengan.dao.EndUserDao;
import com.luomengan.entity.AdminUser;
import com.luomengan.entity.EndUser;

public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private EndUserDao endUserDao;

	@Autowired
	private AdminUserDao adminUserDao;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		String password = authentication.getCredentials().toString();
		if (!(password != null && password.equals(customUserDetails.getPassword()))) {
			throw new BadCredentialsException("密码错误");
		}
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		CustomUsernamePasswordAuthenticationToken customAuth = (CustomUsernamePasswordAuthenticationToken) authentication;
		List<GrantedAuthority> grantedAuthList = new ArrayList<>();
		boolean isAdmin = false;
		Integer userId = null;
		String name = null;
		String password = null;
		if (customAuth.isAdmin()) {
			// 管理用户
			AdminUser user = adminUserDao.retrieveAdminUserByUsername(username);
			if (user == null) {
				throw new UsernameNotFoundException("用户名不存在");
			}
			isAdmin = true;
			userId = user.getId();
			name = user.getName();
			password = user.getPassword();
			grantedAuthList.add(new SimpleGrantedAuthority("Role_Admin"));
		} else {
			// APP用户
			EndUser user = endUserDao.retrieveEndUserByPhone(username);
			if (user == null) {
				throw new UsernameNotFoundException("用户名不存在");
			}
			isAdmin = false;
			userId = user.getId();
			name = user.getName();
			password = user.getPassword();
			grantedAuthList.add(new SimpleGrantedAuthority("Role_App"));
		}
		return new CustomUserDetails(userId, name, username, password, isAdmin, grantedAuthList);
	}

}
