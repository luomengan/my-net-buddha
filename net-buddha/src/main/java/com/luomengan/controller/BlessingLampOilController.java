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

import com.luomengan.entity.BlessingLampOil;
import com.luomengan.pojo.DataResponse;
import com.luomengan.service.BlessingLampOilService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 灯油 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/blessingLampOil")
@Api(description = "灯油接口列表")
public class BlessingLampOilController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public BlessingLampOilService blessingLampOilService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取灯油")
	public DataResponse<BlessingLampOil> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(blessingLampOilService.getBlessingLampOilInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取灯油分页数据")
	public DataResponse<Page<BlessingLampOil>> blessingLampOils(int page, int limit) {
		return new DataResponse<>((Page<BlessingLampOil>) blessingLampOilService.blessingLampOils(page, limit));
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "获取灯油列表")
	public DataResponse<List<BlessingLampOil>> list() {
		return new DataResponse<>(blessingLampOilService.list());
	}
	
	/******************************** 后台管理 **********************************/
	
	@PostMapping("/")
	@ApiOperation(value = "添加灯油", hidden = true)
	public DataResponse<BlessingLampOil> addition(BlessingLampOil blessingLampOil) {
		return new DataResponse<>(blessingLampOilService.addBlessingLampOil(blessingLampOil));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改灯油", hidden = true)
	public DataResponse<BlessingLampOil> modification(BlessingLampOil blessingLampOil) {
		return new DataResponse<>(blessingLampOilService.modifyBlessingLampOil(blessingLampOil));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除灯油", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		blessingLampOilService.deleteBlessingLampOil(id);
		return new DataResponse<Integer>(id);
	}
	
	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除灯油（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		blessingLampOilService.deleteBlessingLampOils(ids);
		return new DataResponse<Boolean>(true);
	}
	
	@GetMapping("/adminList")
	@ApiOperation(value = "获取灯油列表(后台管理)", hidden = true)
	public DataResponse<List<BlessingLampOil>> adminList() {
		return new DataResponse<>(blessingLampOilService.list());
	}

}
