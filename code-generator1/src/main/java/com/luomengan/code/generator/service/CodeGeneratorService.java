package com.luomengan.code.generator.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.luomengan.code.generator.dao.DataColumnDao;
import com.luomengan.code.generator.dao.DataObjectDao;
import com.luomengan.code.generator.dao.ProjectDao;
import com.luomengan.code.generator.entity.DataColumn;
import com.luomengan.code.generator.entity.DataObject;
import com.luomengan.code.generator.entity.Project;
import com.luomengan.code.generator.pojo.DataColumnPojo;
import com.luomengan.code.generator.pojo.DataObjectPojo;
import com.luomengan.code.generator.util.FreeMakerUtil;
import com.luomengan.code.generator.util.enums.ManageTypeEnum;

/**
 * 代码生成器 Service
 * 
 * @author luomengan
 *
 */
@Service
@SuppressWarnings("unused")
public class CodeGeneratorService {

	private static final String backFtlDir = "/ftl/back";
	private static final String frontFtlDir = "/ftl/front";
	private static final String backSkeletonDir = "/skeleton/front";
	private static final String frontSkeletonDir = "/skeleton/front";

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private DataObjectDao dataObjectDao;

	@Autowired
	private DataColumnDao dataColumnDao;

	@Value("${code-dir}")
	private String codeDir;

	public void buildProject(int projectId) {
		try {
			Project project = projectDao.retrieveProjectById(projectId);
			List<DataObject> dataObjectList = dataObjectDao.listDataObjectByProject(projectId);
			// 生成项目骨架
			SkeletonGeneratorService skeleton = new SkeletonGeneratorService(codeDir);
			skeleton.generateSkeleton(project, dataObjectList);
			// 生成各domain前后端代码
			for (DataObject dataObject : dataObjectList) {
				File basePackageDir = skeleton.getBasePackageDir();
				File testBasePackageDir = skeleton.getTestBasePackageDir();
				if (dataObject.getManageType() == ManageTypeEnum.Basic) {
					BaseManageGeneratorService generatorService = new BaseManageGeneratorService(dataColumnDao,
							skeleton);
					generatorService.generateCode(project, dataObject);
				} else if (dataObject.getManageType() == ManageTypeEnum.SelfTree) {
					SelfTreeManageGeneratorService generatorService = new SelfTreeManageGeneratorService(dataColumnDao,
							skeleton);
					generatorService.generateCode(project, dataObject);
				} else {
					BaseManageGeneratorService generatorService = new BaseManageGeneratorService(dataColumnDao,
							skeleton);
					generatorService.generateCode(project, dataObject);
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException("生成代码异常!", ex);
		}
	}

}
