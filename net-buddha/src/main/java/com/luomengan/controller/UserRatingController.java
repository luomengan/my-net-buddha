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

import com.luomengan.entity.UserRating;
import com.luomengan.pojo.DataResponse;
import com.luomengan.service.UserRatingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户评分 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/userRating")
@Api(description = "用户评分接口列表")
public class UserRatingController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public UserRatingService userRatingService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取用户评分", hidden = true)
	public DataResponse<UserRating> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(userRatingService.getUserRatingInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取用户评分分页数据", hidden = true)
	public DataResponse<Page<UserRating>> userRatings(int page, int limit) {
		return new DataResponse<>((Page<UserRating>) userRatingService.userRatings(page, limit));
	}

	@GetMapping("/list")
	@ApiOperation(value = "获取用户评分列表", hidden = true)
	public DataResponse<List<UserRating>> list() {
		return new DataResponse<>(userRatingService.list());
	}

	/******************************** 后台管理 **********************************/

	@PostMapping("/")
	@ApiOperation(value = "添加用户评分", hidden = true)
	public DataResponse<UserRating> addition(UserRating userRating) {
		return new DataResponse<>(userRatingService.addUserRating(userRating));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改用户评分", hidden = true)
	public DataResponse<UserRating> modification(UserRating userRating) {
		return new DataResponse<>(userRatingService.modifyUserRating(userRating));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除用户评分", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		userRatingService.deleteUserRating(id);
		return new DataResponse<Integer>(id);
	}

	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除用户评分（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		userRatingService.deleteUserRatings(ids);
		return new DataResponse<Boolean>(true);
	}

	@GetMapping("/adminList")
	@ApiOperation(value = "获取用户评分列表(后台管理)", hidden = true)
	public DataResponse<List<UserRating>> adminList() {
		return new DataResponse<>(userRatingService.list());
	}

}
