package com.luomengan.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.luomengan.exception.ExceptionEnum;
import com.luomengan.pojo.AdminUserWithToken;
import com.luomengan.pojo.DataResponse;
import com.luomengan.pojo.EndUserWithToken;
import com.luomengan.security.CustomUserDetails;
import com.luomengan.security.CustomUsernamePasswordAuthenticationToken;
import com.luomengan.service.EndUserService;
import com.luomengan.util.JacksonUtil;

import io.swagger.models.HttpMethod;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	private static final String loginUrl = "/login";

	private EndUserService endUserService;

	public JWTLoginFilter(AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(loginUrl, HttpMethod.POST.name()));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		boolean isAdmin = false;
		if ("true".equals(req.getParameter("isAdmin"))) {
			isAdmin = true;
		}
		return getAuthenticationManager().authenticate(new CustomUsernamePasswordAuthenticationToken(
				req.getParameter("username"), req.getParameter("password"), isAdmin));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		// step 1 : 生成token
		CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
		String token = JWTTokenUtil.generateToken(customUserDetails);
		customUserDetails.setToken(token);
		// step 2 : 返回用户信息和token到客户端
		DataResponse<?> result = null;
		if (customUserDetails.isAdmin()) {
			AdminUserWithToken user = new AdminUserWithToken();
			user.setToken(token);
			user.setId(customUserDetails.getUserId());
			user.setName(customUserDetails.getName());
			user.setUsername(customUserDetails.getUsername());
			result = new DataResponse<AdminUserWithToken>(user);
		} else {
			Integer userId = customUserDetails.getUserId();
			EndUserWithToken user = new EndUserWithToken(endUserService.getEndUserInfo(userId));
			user.setToken(token);
			user.setMeritValue(endUserService.getUserMeritValue(userId));
			user.setConsumeMeritValue(endUserService.getUserConsumeMerit(userId));
			result = new DataResponse<EndUserWithToken>(user);
		}
		res.setContentType("application/json;charset=utf-8");
		res.setStatus(HttpServletResponse.SC_OK);
		res.getWriter().println(JacksonUtil.encode(result));
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		DataResponse<String> result = new DataResponse<>(ExceptionEnum.UsernameOrPasswordError_Exception);
		response.getWriter().println(JacksonUtil.encode(result));
	}

	public void setEndUserService(EndUserService endUserService) {
		this.endUserService = endUserService;
	}

}
