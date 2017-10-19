package com.luomengan.code.generator.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.luomengan.code.generator.dao.DataColumnDao;
import com.luomengan.code.generator.entity.DataObject;
import com.luomengan.code.generator.entity.Project;
import com.luomengan.code.generator.pojo.DataColumnPojo;
import com.luomengan.code.generator.pojo.DataObjectPojo;
import com.luomengan.code.generator.util.FreeMakerUtil;

/**
 * 
 * @author luomengan
 *
 */
public class SelfTreeManageGeneratorService {

	private File basePackageDir;

	private File testBasePackageDir;

	private File frontDirFile;

	private String backFtlDir = SkeletonGeneratorService.backFtlDir;

	private String frontFtlDir = SkeletonGeneratorService.frontFtlDir;

	private DataColumnDao dataColumnDao;

	public SelfTreeManageGeneratorService(DataColumnDao dataColumnDao, SkeletonGeneratorService skeleton) {
		this.dataColumnDao = dataColumnDao;
		this.basePackageDir = skeleton.getBasePackageDir();
		this.testBasePackageDir = skeleton.getTestBasePackageDir();
		this.frontDirFile = skeleton.getFrontDirFile();
	}

	public void generateCode(Project project, DataObject dataObject) {
		generateBackCode(project, dataObject);
		generateFrontCode(project, dataObject);
	}

	private void generateBackCode(Project project, DataObject dataObject) {
		Map<String, Object> projectRoot = new HashMap<>();
		projectRoot.put("mavenGroupId", project.getMavenGroupId());
		projectRoot.put("mavenArtifactId", project.getMavenArtifactId());
		projectRoot.put("mavenVersion", project.getMavenVersion());
		projectRoot.put("projectName", project.getName());
		projectRoot.put("projectDescription", project.getDescription());
		projectRoot.put("basePackage", project.getBasePackage());
		DataObjectPojo dataObjectPojo = DataObjectPojo.getPojo(dataObject);
		projectRoot.put("dataObjectPojo", dataObjectPojo);
		projectRoot.put("dataColumnPojoList",
				DataColumnPojo.getPojoList(dataColumnDao.listDataColumnsByDataObject(dataObject)));
		// step 7 : 生成Entity
		FreeMakerUtil.generateFile(backFtlDir + "/entity", "DataObject_SelfTree.ftl", projectRoot,
				new File(basePackageDir, "entity/" + dataObject.getName() + ".java"));
		// step 8 : 生成dao
		FreeMakerUtil.generateFile(backFtlDir + "/dao", "DataObjectRepository.ftl", projectRoot,
				new File(basePackageDir, "dao/impl/jpa/" + dataObject.getName() + "Repository.java"));
		FreeMakerUtil.generateFile(backFtlDir + "/dao", "DataObjectDao.ftl", projectRoot,
				new File(basePackageDir, "dao/" + dataObject.getName() + "Dao.java"));
		FreeMakerUtil.generateFile(backFtlDir + "/dao", "DataObjectDaoImpl.ftl", projectRoot,
				new File(basePackageDir, "dao/impl/" + dataObject.getName() + "DaoImpl.java"));
		// step 9 : 生成service
		FreeMakerUtil.generateFile(backFtlDir + "/service", "DataObjectService.ftl", projectRoot,
				new File(basePackageDir, "service/" + dataObject.getName() + "Service.java"));
		// step 10 : 生成controller
		FreeMakerUtil.generateFile(backFtlDir + "/controller", "DataObjectController.ftl", projectRoot,
				new File(basePackageDir, "controller/" + dataObject.getName() + "Controller.java"));
		// step 11 : 生成controllerTest
		FreeMakerUtil.generateFile(backFtlDir + "/controller", "DataObjectControllerTest.ftl", projectRoot,
				new File(testBasePackageDir, "controller/" + dataObject.getName() + "ControllerTest.java"));
	}

	private void generateFrontCode(Project project, DataObject dataObject) {
		Map<String, Object> projectRoot = new HashMap<>();
		projectRoot.put("mavenGroupId", project.getMavenGroupId());
		projectRoot.put("mavenArtifactId", project.getMavenArtifactId());
		projectRoot.put("mavenVersion", project.getMavenVersion());
		projectRoot.put("projectName", project.getName());
		projectRoot.put("projectDescription", project.getDescription());
		projectRoot.put("basePackage", project.getBasePackage());
		projectRoot.put("adminWebTitle", project.getAdminWebTitle());
		projectRoot.put("adminWebMetaDescription", project.getAdminWebMetaDescription());
		DataObjectPojo dataObjectPojo = DataObjectPojo.getPojo(dataObject);
		projectRoot.put("dataObjectPojo", dataObjectPojo);
		projectRoot.put("dataColumnPojoList",
				DataColumnPojo.getPojoList(dataColumnDao.listDataColumnsByDataObject(dataObject)));
		// step 5.1 : 生成数据对象js
		FreeMakerUtil.generateFile(frontFtlDir + "/src/js/controllers", "data-object_js.ftl", projectRoot,
				new File(frontDirFile + "/src/js/controllers", dataObjectPojo.getJsName() + ".js"));
		// step 5.2 : 生成数据对象html
		FreeMakerUtil.generateFile(frontFtlDir + "/src/html/dataObject", "dataObject_add_html.ftl", projectRoot,
				new File(frontDirFile + "/src/html/" + dataObjectPojo.getHumpName(),
						dataObjectPojo.getHumpName() + "_add.html"));
		FreeMakerUtil.generateFile(frontFtlDir + "/src/html/dataObject", "dataObject_admin_html.ftl", projectRoot,
				new File(frontDirFile + "/src/html/" + dataObjectPojo.getHumpName(),
						dataObjectPojo.getHumpName() + "_admin.html"));
		FreeMakerUtil.generateFile(frontFtlDir + "/src/html/dataObject", "dataObject_edit_html.ftl", projectRoot,
				new File(frontDirFile + "/src/html/" + dataObjectPojo.getHumpName(),
						dataObjectPojo.getHumpName() + "_edit.html"));
	}

}
