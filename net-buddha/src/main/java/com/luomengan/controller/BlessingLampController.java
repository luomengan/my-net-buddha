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

import com.luomengan.entity.BlessingLamp;
import com.luomengan.pojo.DataResponse;
import com.luomengan.service.BlessingLampService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 祈福明灯 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/blessingLamp")
@Api(description = "祈福明灯接口列表")
public class BlessingLampController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public BlessingLampService blessingLampService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取祈福明灯")
	public DataResponse<BlessingLamp> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(blessingLampService.getBlessingLampInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取祈福明灯分页数据")
	public DataResponse<Page<BlessingLamp>> blessingLamps(int page, int limit) {
		return new DataResponse<>((Page<BlessingLamp>) blessingLampService.blessingLamps(page, limit));
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "获取祈福明灯列表")
	public DataResponse<List<BlessingLamp>> list() {
		return new DataResponse<>(blessingLampService.list());
	}
	
	/******************************** 后台管理 **********************************/
	
	@PostMapping("/")
	@ApiOperation(value = "添加祈福明灯", hidden = true)
	public DataResponse<BlessingLamp> addition(BlessingLamp blessingLamp) {
		return new DataResponse<>(blessingLampService.addBlessingLamp(blessingLamp));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改祈福明灯", hidden = true)
	public DataResponse<BlessingLamp> modification(BlessingLamp blessingLamp) {
		return new DataResponse<>(blessingLampService.modifyBlessingLamp(blessingLamp));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除祈福明灯", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		blessingLampService.deleteBlessingLamp(id);
		return new DataResponse<Integer>(id);
	}
	
	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除祈福明灯（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		blessingLampService.deleteBlessingLamps(ids);
		return new DataResponse<Boolean>(true);
	}
	
	@GetMapping("/adminList")
	@ApiOperation(value = "获取祈福明灯列表(后台管理)", hidden = true)
	public DataResponse<List<BlessingLamp>> adminList() {
		return new DataResponse<>(blessingLampService.list());
	}

}
