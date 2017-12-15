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

import com.luomengan.entity.Almanac;
import com.luomengan.pojo.DataResponse;
import com.luomengan.service.AlmanacService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 黄历+佛历 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/almanac")
@Api(description = "黄历+佛历接口列表")
public class AlmanacController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public AlmanacService almanacService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取黄历+佛历")
	public DataResponse<Almanac> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(almanacService.getAlmanacInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取黄历+佛历分页数据")
	public DataResponse<Page<Almanac>> almanacs(int page, int limit) {
		return new DataResponse<>((Page<Almanac>) almanacService.almanacs(page, limit));
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "获取黄历+佛历列表")
	public DataResponse<List<Almanac>> list() {
		return new DataResponse<>(almanacService.list());
	}
	
	/******************************** 后台管理 **********************************/
	
	@PostMapping("/")
	@ApiOperation(value = "添加黄历+佛历", hidden = true)
	public DataResponse<Almanac> addition(Almanac almanac) {
		return new DataResponse<>(almanacService.addAlmanac(almanac));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改黄历+佛历", hidden = true)
	public DataResponse<Almanac> modification(Almanac almanac) {
		return new DataResponse<>(almanacService.modifyAlmanac(almanac));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除黄历+佛历", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		almanacService.deleteAlmanac(id);
		return new DataResponse<Integer>(id);
	}
	
	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除黄历+佛历（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		almanacService.deleteAlmanacs(ids);
		return new DataResponse<Boolean>(true);
	}
	
	@GetMapping("/adminList")
	@ApiOperation(value = "获取黄历+佛历列表(后台管理)", hidden = true)
	public DataResponse<List<Almanac>> adminList() {
		return new DataResponse<>(almanacService.list());
	}

}
