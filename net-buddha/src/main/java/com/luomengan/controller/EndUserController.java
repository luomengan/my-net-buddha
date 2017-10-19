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

import com.luomengan.entity.EndUser;
import com.luomengan.pojo.DataResponse;
import com.luomengan.pojo.Response;
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

	@Autowired
	public EndUserService endUserService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取终端用户")
	public Response<EndUser> fetchById(@PathVariable Integer id) {
		return new Response<>(endUserService.getEndUserInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取终端用户分页数据", hidden = true)
	public Response<Page<EndUser>> endUsers(int page, int limit) {
		return new Response<>((Page<EndUser>) endUserService.endUsers(page, limit));
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "获取终端用户列表", hidden = true)
	public Response<List<EndUser>> list() {
		return new Response<>(endUserService.list());
	}
	
	/******************************** 后台管理 **********************************/
	
	@PostMapping("/")
	@ApiOperation(value = "添加终端用户", hidden = true)
	public Response<EndUser> addition(EndUser endUser) {
		return new Response<>(endUserService.addEndUser(endUser));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改终端用户", hidden = true)
	public Response<EndUser> modification(EndUser endUser) {
		return new Response<>(endUserService.modifyEndUser(endUser));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除终端用户", hidden = true)
	public Response<Integer> delete(@PathVariable Integer id) {
		endUserService.deleteEndUser(id);
		return new Response<Integer>(id);
	}
	
	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除终端用户（多个id以逗号分割）", hidden = true)
	public Response<Boolean> deletes(String ids) {
		endUserService.deleteEndUsers(ids);
		return new Response<Boolean>(true);
	}
	
	@GetMapping("/adminList")
	@ApiOperation(value = "获取终端用户列表(后台管理)", hidden = true)
	public DataResponse<List<EndUser>> adminList() {
		return new DataResponse<>(endUserService.list());
	}

}
