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

import com.luomengan.entity.Joss;
import com.luomengan.pojo.DataResponse;
import com.luomengan.service.JossService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 佛像 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/joss")
@Api(description = "佛像接口列表")
public class JossController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public JossService jossService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取佛像")
	public DataResponse<Joss> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(jossService.getJossInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取佛像分页数据")
	public DataResponse<Page<Joss>> josss(int page, int limit) {
		return new DataResponse<>((Page<Joss>) jossService.josss(page, limit));
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "获取佛像列表")
	public DataResponse<List<Joss>> list() {
		return new DataResponse<>(jossService.list());
	}
	
	/******************************** 后台管理 **********************************/
	
	@PostMapping("/")
	@ApiOperation(value = "添加佛像", hidden = true)
	public DataResponse<Joss> addition(Joss joss) {
		return new DataResponse<>(jossService.addJoss(joss));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改佛像", hidden = true)
	public DataResponse<Joss> modification(Joss joss) {
		return new DataResponse<>(jossService.modifyJoss(joss));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除佛像", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		jossService.deleteJoss(id);
		return new DataResponse<Integer>(id);
	}
	
	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除佛像（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		jossService.deleteJosss(ids);
		return new DataResponse<Boolean>(true);
	}
	
	@GetMapping("/adminList")
	@ApiOperation(value = "获取佛像列表(后台管理)", hidden = true)
	public DataResponse<List<Joss>> adminList() {
		return new DataResponse<>(jossService.list());
	}

}
