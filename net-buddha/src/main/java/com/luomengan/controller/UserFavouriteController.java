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

import com.luomengan.entity.UserFavourite;
import com.luomengan.pojo.DataResponse;
import com.luomengan.pojo.Response;
import com.luomengan.service.UserFavouriteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户收藏 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/userFavourite")
@Api(description = "用户收藏接口列表")
public class UserFavouriteController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public UserFavouriteService userFavouriteService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取用户收藏", hidden = true)
	public Response<UserFavourite> fetchById(@PathVariable Integer id) {
		return new Response<>(userFavouriteService.getUserFavouriteInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取用户收藏分页数据", hidden = true)
	public Response<Page<UserFavourite>> userFavourites(int page, int limit) {
		return new Response<>((Page<UserFavourite>) userFavouriteService.userFavourites(page, limit));
	}

	@GetMapping("/list")
	@ApiOperation(value = "获取用户收藏列表", hidden = true)
	public Response<List<UserFavourite>> list() {
		return new Response<>(userFavouriteService.list());
	}

	/******************************** 后台管理 **********************************/

	@PostMapping("/")
	@ApiOperation(value = "添加用户收藏", hidden = true)
	public Response<UserFavourite> addition(UserFavourite userFavourite) {
		return new Response<>(userFavouriteService.addUserFavourite(userFavourite));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改用户收藏", hidden = true)
	public Response<UserFavourite> modification(UserFavourite userFavourite) {
		return new Response<>(userFavouriteService.modifyUserFavourite(userFavourite));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除用户收藏", hidden = true)
	public Response<Integer> delete(@PathVariable Integer id) {
		userFavouriteService.deleteUserFavourite(id);
		return new Response<Integer>(id);
	}

	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除用户收藏（多个id以逗号分割）", hidden = true)
	public Response<Boolean> deletes(String ids) {
		userFavouriteService.deleteUserFavourites(ids);
		return new Response<Boolean>(true);
	}

	@GetMapping("/adminList")
	@ApiOperation(value = "获取用户收藏列表(后台管理)", hidden = true)
	public DataResponse<List<UserFavourite>> adminList() {
		return new DataResponse<>(userFavouriteService.list());
	}

}
