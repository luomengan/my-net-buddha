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

import com.luomengan.entity.Offering;
import com.luomengan.pojo.DataResponse;
import com.luomengan.service.OfferingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 供品 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/offering")
@Api(description = "供品接口列表")
public class OfferingController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public OfferingService offeringService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取供品")
	public DataResponse<Offering> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(offeringService.getOfferingInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取供品分页数据")
	public DataResponse<Page<Offering>> offerings(int page, int limit) {
		return new DataResponse<>((Page<Offering>) offeringService.offerings(page, limit));
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "获取供品列表")
	public DataResponse<List<Offering>> list() {
		return new DataResponse<>(offeringService.list());
	}
	
	/******************************** 后台管理 **********************************/
	
	@PostMapping("/")
	@ApiOperation(value = "添加供品", hidden = true)
	public DataResponse<Offering> addition(Offering offering) {
		return new DataResponse<>(offeringService.addOffering(offering));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改供品", hidden = true)
	public DataResponse<Offering> modification(Offering offering) {
		return new DataResponse<>(offeringService.modifyOffering(offering));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除供品", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		offeringService.deleteOffering(id);
		return new DataResponse<Integer>(id);
	}
	
	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除供品（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		offeringService.deleteOfferings(ids);
		return new DataResponse<Boolean>(true);
	}
	
	@GetMapping("/adminList")
	@ApiOperation(value = "获取供品列表(后台管理)", hidden = true)
	public DataResponse<List<Offering>> adminList() {
		return new DataResponse<>(offeringService.list());
	}

}
