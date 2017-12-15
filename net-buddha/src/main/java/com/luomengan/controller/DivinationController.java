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

import com.luomengan.entity.Divination;
import com.luomengan.pojo.DataResponse;
import com.luomengan.service.DivinationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 灵签 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/divination")
@Api(description = "灵签接口列表")
public class DivinationController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public DivinationService divinationService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取灵签")
	public DataResponse<Divination> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(divinationService.getDivinationInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取灵签分页数据")
	public DataResponse<Page<Divination>> divinations(int page, int limit) {
		return new DataResponse<>((Page<Divination>) divinationService.divinations(page, limit));
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "获取灵签列表")
	public DataResponse<List<Divination>> list() {
		return new DataResponse<>(divinationService.list());
	}
	
	/******************************** 后台管理 **********************************/
	
	@PostMapping("/")
	@ApiOperation(value = "添加灵签", hidden = true)
	public DataResponse<Divination> addition(Divination divination) {
		return new DataResponse<>(divinationService.addDivination(divination));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改灵签", hidden = true)
	public DataResponse<Divination> modification(Divination divination) {
		return new DataResponse<>(divinationService.modifyDivination(divination));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除灵签", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		divinationService.deleteDivination(id);
		return new DataResponse<Integer>(id);
	}
	
	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除灵签（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		divinationService.deleteDivinations(ids);
		return new DataResponse<Boolean>(true);
	}
	
	@GetMapping("/adminList")
	@ApiOperation(value = "获取灵签列表(后台管理)", hidden = true)
	public DataResponse<List<Divination>> adminList() {
		return new DataResponse<>(divinationService.list());
	}

}
