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

import com.luomengan.code.generator.entity.DataObject;
import com.luomengan.code.generator.pojo.DataResponse;
import com.luomengan.code.generator.pojo.Response;
import com.luomengan.code.generator.service.DataObjectService;

import io.swagger.annotations.ApiOperation;

/**
 * 数据对象 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/dataObject")
public class DataObjectController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public DataObjectService dataObjectService;

	@GetMapping("/{id}")
	public Response<DataObject> fetchById(@PathVariable Integer id) {
		return new Response<>(dataObjectService.getDataObjectInfo(id));
	}

	@GetMapping("/page")
	public Response<Page<DataObject>> dataObjects(int page, int limit) {
		return new Response<>((Page<DataObject>) dataObjectService.dataObjects(page, limit));
	}

	/******************************** 后台管理 **********************************/

	@PostMapping("/")
	@ApiOperation(value = "添加数据对象", hidden = true)
	public Response<DataObject> addition(DataObject dataObject, Integer projectId) {
		return new Response<>(dataObjectService.addDataObject(dataObject, projectId));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改数据对象", hidden = true)
	public Response<DataObject> modification(DataObject dataObject, Integer projectId) {
		return new Response<>(dataObjectService.modifyDataObject(dataObject, projectId));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除数据对象", hidden = true)
	public Response<Integer> delete(@PathVariable Integer id) {
		dataObjectService.deleteDataObject(id);
		return new Response<Integer>(id);
	}

	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除数据对象（多个id以逗号分割）", hidden = true)
	public Response<Boolean> deletes(String ids) {
		dataObjectService.deleteDataObjects(ids);
		return new Response<Boolean>(true);
	}

	@GetMapping("/adminList")
	@ApiOperation(value = "获取数据对象列表(后台管理)", hidden = true)
	public DataResponse<List<DataObject>> adminList() {
		return new DataResponse<>(dataObjectService.list());
	}

}
