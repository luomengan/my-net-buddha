package com.luomengan.code.generator.controller;

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

import com.luomengan.code.generator.entity.DataColumn;
import com.luomengan.code.generator.pojo.DataResponse;
import com.luomengan.code.generator.pojo.Response;
import com.luomengan.code.generator.service.DataColumnService;

import io.swagger.annotations.ApiOperation;

/**
 * 数据列 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/dataColumn")
public class DataColumnController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public DataColumnService dataColumnService;

	@GetMapping("/{id}")
	public Response<DataColumn> fetchById(@PathVariable Integer id) {
		return new Response<>(dataColumnService.getDataColumnInfo(id));
	}

	@GetMapping("/page")
	public Response<Page<DataColumn>> dataColumns(int page, int limit) {
		return new Response<>((Page<DataColumn>) dataColumnService.dataColumns(page, limit));
	}

	/******************************** 后台管理 **********************************/

	@PostMapping("/")
	@ApiOperation(value = "添加数据列", hidden = true)
	public Response<DataColumn> addition(DataColumn dataColumn, Integer dataObjectId) {
		return new Response<>(dataColumnService.addDataColumn(dataColumn, dataObjectId));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改数据列", hidden = true)
	public Response<DataColumn> modification(DataColumn dataColumn, Integer dataObjectId) {
		return new Response<>(dataColumnService.modifyDataColumn(dataColumn, dataObjectId));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除数据列", hidden = true)
	public Response<Integer> delete(@PathVariable Integer id) {
		dataColumnService.deleteDataColumn(id);
		return new Response<Integer>(id);
	}

	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除数据列（多个id以逗号分割）", hidden = true)
	public Response<Boolean> deletes(String ids) {
		dataColumnService.deleteDataColumns(ids);
		return new Response<Boolean>(true);
	}

	@GetMapping("/adminList")
	@ApiOperation(value = "获取数据列列表(后台管理)", hidden = true)
	public DataResponse<List<DataColumn>> adminList() {
		return new DataResponse<>(dataColumnService.list());
	}

}
