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

import com.luomengan.entity.Rune;
import com.luomengan.pojo.DataResponse;
import com.luomengan.service.RuneService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 符文 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/rune")
@Api(description = "符文接口列表")
public class RuneController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public RuneService runeService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取符文")
	public DataResponse<Rune> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(runeService.getRuneInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取符文分页数据")
	public DataResponse<Page<Rune>> runes(int page, int limit) {
		return new DataResponse<>((Page<Rune>) runeService.runes(page, limit));
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "获取符文列表")
	public DataResponse<List<Rune>> list() {
		return new DataResponse<>(runeService.list());
	}
	
	/******************************** 后台管理 **********************************/
	
	@PostMapping("/")
	@ApiOperation(value = "添加符文", hidden = true)
	public DataResponse<Rune> addition(Rune rune) {
		return new DataResponse<>(runeService.addRune(rune));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改符文", hidden = true)
	public DataResponse<Rune> modification(Rune rune) {
		return new DataResponse<>(runeService.modifyRune(rune));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除符文", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		runeService.deleteRune(id);
		return new DataResponse<Integer>(id);
	}
	
	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除符文（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		runeService.deleteRunes(ids);
		return new DataResponse<Boolean>(true);
	}
	
	@GetMapping("/adminList")
	@ApiOperation(value = "获取符文列表(后台管理)", hidden = true)
	public DataResponse<List<Rune>> adminList() {
		return new DataResponse<>(runeService.list());
	}

}
