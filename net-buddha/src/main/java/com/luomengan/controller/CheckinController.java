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

import com.luomengan.entity.Checkin;
import com.luomengan.pojo.DataResponse;
import com.luomengan.service.CheckinService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 签到 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/checkin")
@Api(description = "签到接口列表")
public class CheckinController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public CheckinService checkinService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取签到")
	public DataResponse<Checkin> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(checkinService.getCheckinInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取签到分页数据")
	public DataResponse<Page<Checkin>> checkins(int page, int limit) {
		return new DataResponse<>((Page<Checkin>) checkinService.checkins(page, limit));
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "获取签到列表")
	public DataResponse<List<Checkin>> list() {
		return new DataResponse<>(checkinService.list());
	}
	
	/******************************** 后台管理 **********************************/
	
	@PostMapping("/")
	@ApiOperation(value = "添加签到", hidden = true)
	public DataResponse<Checkin> addition(Checkin checkin) {
		return new DataResponse<>(checkinService.addCheckin(checkin));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改签到", hidden = true)
	public DataResponse<Checkin> modification(Checkin checkin) {
		return new DataResponse<>(checkinService.modifyCheckin(checkin));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除签到", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		checkinService.deleteCheckin(id);
		return new DataResponse<Integer>(id);
	}
	
	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除签到（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		checkinService.deleteCheckins(ids);
		return new DataResponse<Boolean>(true);
	}
	
	@GetMapping("/adminList")
	@ApiOperation(value = "获取签到列表(后台管理)", hidden = true)
	public DataResponse<List<Checkin>> adminList() {
		return new DataResponse<>(checkinService.list());
	}

}
