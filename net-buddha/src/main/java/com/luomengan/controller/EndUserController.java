package com.luomengan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.luomengan.entity.EndUser;
import com.luomengan.pojo.DataResponse;
import com.luomengan.pojo.EndUserWithToken;
import com.luomengan.security.CustomUserDetails;
import com.luomengan.security.SecurityUtil;
import com.luomengan.security.jwt.JWTTokenUtil;
import com.luomengan.service.EndUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 终端用户 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/endUser")
@Api(description = "终端用户接口列表")
public class EndUserController {

	Logger logger = LoggerFactory.getLogger(getClass());

	public static ThreadLocal<MultipartFile> uploadHeadPortraitLocal = new ThreadLocal<>();

	@Autowired
	public EndUserService endUserService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取终端用户")
	public DataResponse<EndUserWithToken> fetchById(@PathVariable Integer id) {
		EndUserWithToken result = new EndUserWithToken(endUserService.getEndUserInfo(id));
		if (result.getId() != null && result.getId() > 0) {
			result.setPassword(null);
			result.setMeritValue(endUserService.getUserMeritValue(result.getId()));
			result.setConsumeMeritValue(endUserService.getUserConsumeMerit(result.getId()));
		}
		return new DataResponse<>(result);
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取终端用户分页数据", hidden = true)
	public DataResponse<Page<EndUser>> endUsers(int page, int limit) {
		return new DataResponse<>((Page<EndUser>) endUserService.endUsers(page, limit));
	}

	@GetMapping("/list")
	@ApiOperation(value = "获取终端用户列表", hidden = true)
	public DataResponse<List<EndUser>> list() {
		return new DataResponse<>(endUserService.list());
	}

	@PostMapping("/register")
	@ApiOperation(value = "用户注册")
	public DataResponse<EndUserWithToken> register(String phone, String password) {
		EndUserWithToken result = new EndUserWithToken(endUserService.register(phone, password));
		if (result.getId() != null && result.getId() > 0) {
			result.setPassword(null);
			result.setMeritValue(endUserService.getUserMeritValue(result.getId()));
			result.setConsumeMeritValue(endUserService.getUserConsumeMerit(result.getId()));
			// 注册成功，返回token
			List<GrantedAuthority> grantedAuthList = new ArrayList<>();
			grantedAuthList.add(new SimpleGrantedAuthority("Role_App"));
			result.setToken(JWTTokenUtil.generateToken(
					new CustomUserDetails(result.getId(), result.getName(), phone, password, false, grantedAuthList)));
		}
		return new DataResponse<>(result);
	}

	@PostMapping("/modify")
	@ApiOperation(value = "修改个人资料")
	public DataResponse<EndUserWithToken> complete(EndUser user) {
		EndUserWithToken result = new EndUserWithToken(endUserService.modifyEndUser(user));
		if (result.getId() != null && result.getId() > 0) {
			result.setPassword(null);
			result.setMeritValue(endUserService.getUserMeritValue(result.getId()));
			result.setConsumeMeritValue(endUserService.getUserConsumeMerit(result.getId()));
		}
		return new DataResponse<>(result);
	}

	@ApiOperation(value = "上传用户头像")
	@PostMapping("/uploadHeadPortrait")
	public DataResponse<String> uploadHeadPortrait(@RequestParam("file") MultipartFile file,
			HttpServletRequest request) {
		return new DataResponse<>(endUserService.uploadHeadPortrait(SecurityUtil.getUserId(), file));
	}

	@GetMapping("/getCurrent")
	@ApiOperation(value = "获取当前用户信息")
	public DataResponse<EndUserWithToken> getCurrent() {
		EndUserWithToken result = new EndUserWithToken(endUserService.getEndUserInfo(SecurityUtil.getUserId()));
		if (result.getId() != null && result.getId() > 0) {
			result.setPassword(null);
			result.setMeritValue(endUserService.getUserMeritValue(result.getId()));
			result.setConsumeMeritValue(endUserService.getUserConsumeMerit(result.getId()));
		}
		return new DataResponse<>(result);
	}

	/******************************** 后台管理 **********************************/

	@PostMapping("/")
	@ApiOperation(value = "添加终端用户", hidden = true)
	public DataResponse<EndUser> addition(EndUser endUser) {
		return new DataResponse<>(endUserService.addEndUser(endUser));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改终端用户", hidden = true)
	public DataResponse<EndUser> modification(EndUser endUser) {
		return new DataResponse<>(endUserService.modifyEndUser(endUser));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除终端用户", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		endUserService.deleteEndUser(id);
		return new DataResponse<Integer>(id);
	}

	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除终端用户（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		endUserService.deleteEndUsers(ids);
		return new DataResponse<Boolean>(true);
	}

	@GetMapping("/adminList")
	@ApiOperation(value = "获取终端用户列表(后台管理)", hidden = true)
	public DataResponse<List<EndUser>> adminList() {
		return new DataResponse<>(endUserService.list());
	}

}
