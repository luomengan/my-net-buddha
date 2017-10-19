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

import com.luomengan.code.generator.entity.Project;
import com.luomengan.code.generator.pojo.DataResponse;
import com.luomengan.code.generator.pojo.Response;
import com.luomengan.code.generator.service.ProjectService;

import io.swagger.annotations.ApiOperation;

/**
 * 项目 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public ProjectService projectService;

	@GetMapping("/{id}")
	public Response<Project> fetchById(@PathVariable Integer id) {
		return new Response<>(projectService.getProjectInfo(id));
	}

	@GetMapping("/page")
	public Response<Page<Project>> projects(int page, int limit) {
		return new Response<>((Page<Project>) projectService.projects(page, limit));
	}
	
	/******************************** 后台管理 **********************************/
	
	@PostMapping("/")
	@ApiOperation(value = "添加项目", hidden = true)
	public Response<Project> addition(Project project) {
		return new Response<>(projectService.addProject(project));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改项目", hidden = true)
	public Response<Project> modification(Project project) {
		return new Response<>(projectService.modifyProject(project));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除项目", hidden = true)
	public Response<Integer> delete(@PathVariable Integer id) {
		projectService.deleteProject(id);
		return new Response<Integer>(id);
	}
	
	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除项目（多个id以逗号分割）", hidden = true)
	public Response<Boolean> deletes(String ids) {
		projectService.deleteProjects(ids);
		return new Response<Boolean>(true);
	}
	
	@GetMapping("/adminList")
	@ApiOperation(value = "获取项目列表(后台管理)", hidden = true)
	public DataResponse<List<Project>> adminList() {
		return new DataResponse<>(projectService.list());
	}

}
