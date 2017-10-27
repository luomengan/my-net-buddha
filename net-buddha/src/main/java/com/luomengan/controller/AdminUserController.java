package com.luomengan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luomengan.entity.AdminUser;
import com.luomengan.pojo.DataResponse;
import com.luomengan.service.AdminUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 管理用户 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/adminUser")
@Api(description = "管理用户接口列表", hidden = true)
public class AdminUserController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public AdminUserService adminUserService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取管理用户", hidden = true)
	public DataResponse<AdminUser> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(adminUserService.getAdminUserInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取管理用户分页数据", hidden = true)
	public DataResponse<Page<AdminUser>> adminUsers(int page, int limit) {
		return new DataResponse<>((Page<AdminUser>) adminUserService.adminUsers(page, limit));
	}

	@GetMapping("/list")
	@ApiOperation(value = "获取管理用户列表", hidden = true)
	public DataResponse<List<AdminUser>> list() {
		return new DataResponse<>(adminUserService.list());
	}

	/******************************** 后台管理 **********************************/

	@PostMapping("/")
	@ApiOperation(value = "添加管理用户", hidden = true)
	public DataResponse<AdminUser> addition(AdminUser adminUser) {
		return new DataResponse<>(adminUserService.addAdminUser(adminUser));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改管理用户", hidden = true)
	public DataResponse<AdminUser> modification(AdminUser adminUser) {
		return new DataResponse<>(adminUserService.modifyAdminUser(adminUser));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除管理用户", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		adminUserService.deleteAdminUser(id);
		return new DataResponse<Integer>(id);
	}

	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除管理用户（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		adminUserService.deleteAdminUsers(ids);
		return new DataResponse<Boolean>(true);
	}

	@GetMapping("/adminList")
	@ApiOperation(value = "获取管理用户列表(后台管理)", hidden = true)
	public DataResponse<List<AdminUser>> adminList() {
		return new DataResponse<>(adminUserService.list());
	}

}
