package ${basePackage}.controller;

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

import ${basePackage}.entity.${dataObjectPojo.name};
import ${basePackage}.pojo.DataResponse;
import ${basePackage}.service.${dataObjectPojo.name}Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * ${dataObjectPojo.description} Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/${dataObjectPojo.humpName}")
@Api(description = "${dataObjectPojo.description}接口列表")
public class ${dataObjectPojo.name}Controller {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public ${dataObjectPojo.name}Service ${dataObjectPojo.humpName}Service;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取${dataObjectPojo.description}")
	public DataResponse<${dataObjectPojo.name}> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(${dataObjectPojo.humpName}Service.get${dataObjectPojo.name}Info(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取${dataObjectPojo.description}分页数据")
	public DataResponse<Page<${dataObjectPojo.name}>> ${dataObjectPojo.humpName}s(int page, int limit) {
		return new DataResponse<>((Page<${dataObjectPojo.name}>) ${dataObjectPojo.humpName}Service.${dataObjectPojo.humpName}s(page, limit));
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "获取${dataObjectPojo.description}列表")
	public DataResponse<List<${dataObjectPojo.name}>> list() {
		return new DataResponse<>(${dataObjectPojo.humpName}Service.list());
	}
	
	/******************************** 后台管理 **********************************/
	
	@PostMapping("/")
	@ApiOperation(value = "添加${dataObjectPojo.description}", hidden = true)
	public DataResponse<${dataObjectPojo.name}> addition(${dataObjectPojo.name} ${dataObjectPojo.humpName}) {
		return new DataResponse<>(${dataObjectPojo.humpName}Service.add${dataObjectPojo.name}(${dataObjectPojo.humpName}));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改${dataObjectPojo.description}", hidden = true)
	public DataResponse<${dataObjectPojo.name}> modification(${dataObjectPojo.name} ${dataObjectPojo.humpName}) {
		return new DataResponse<>(${dataObjectPojo.humpName}Service.modify${dataObjectPojo.name}(${dataObjectPojo.humpName}));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除${dataObjectPojo.description}", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		${dataObjectPojo.humpName}Service.delete${dataObjectPojo.name}(id);
		return new DataResponse<Integer>(id);
	}
	
	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除${dataObjectPojo.description}（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		${dataObjectPojo.humpName}Service.delete${dataObjectPojo.name}s(ids);
		return new DataResponse<Boolean>(true);
	}
	
	@GetMapping("/adminList")
	@ApiOperation(value = "获取${dataObjectPojo.description}列表(后台管理)", hidden = true)
	public DataResponse<List<${dataObjectPojo.name}>> adminList() {
		return new DataResponse<>(${dataObjectPojo.humpName}Service.list());
	}

}
