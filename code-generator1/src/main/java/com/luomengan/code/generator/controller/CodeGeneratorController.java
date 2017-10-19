package com.luomengan.code.generator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luomengan.code.generator.pojo.Response;
import com.luomengan.code.generator.service.CodeGeneratorService;

/**
 * 代码生成器 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/work")
public class CodeGeneratorController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public CodeGeneratorService codeGeneratorService;

	@PostMapping("/buildProject")
	public Response<Integer> buildProject(int projectId) {
		codeGeneratorService.buildProject(projectId);
		return new Response<>(projectId);
	}

}
