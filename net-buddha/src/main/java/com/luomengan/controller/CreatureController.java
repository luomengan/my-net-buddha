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

import com.luomengan.entity.Creature;
import com.luomengan.pojo.DataResponse;
import com.luomengan.service.CreatureService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 生灵 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/creature")
@Api(description = "生灵接口列表")
public class CreatureController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public CreatureService creatureService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取生灵")
	public DataResponse<Creature> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(creatureService.getCreatureInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取生灵分页数据")
	public DataResponse<Page<Creature>> creatures(int page, int limit) {
		return new DataResponse<>((Page<Creature>) creatureService.creatures(page, limit));
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "获取生灵列表")
	public DataResponse<List<Creature>> list() {
		return new DataResponse<>(creatureService.list());
	}
	
	/******************************** 后台管理 **********************************/
	
	@PostMapping("/")
	@ApiOperation(value = "添加生灵", hidden = true)
	public DataResponse<Creature> addition(Creature creature) {
		return new DataResponse<>(creatureService.addCreature(creature));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改生灵", hidden = true)
	public DataResponse<Creature> modification(Creature creature) {
		return new DataResponse<>(creatureService.modifyCreature(creature));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除生灵", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		creatureService.deleteCreature(id);
		return new DataResponse<Integer>(id);
	}
	
	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除生灵（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		creatureService.deleteCreatures(ids);
		return new DataResponse<Boolean>(true);
	}
	
	@GetMapping("/adminList")
	@ApiOperation(value = "获取生灵列表(后台管理)", hidden = true)
	public DataResponse<List<Creature>> adminList() {
		return new DataResponse<>(creatureService.list());
	}

}
