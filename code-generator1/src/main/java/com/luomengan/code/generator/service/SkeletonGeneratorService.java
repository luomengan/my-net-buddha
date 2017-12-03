package com.luomengan.code.generator.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.luomengan.code.generator.entity.DataObject;
import com.luomengan.code.generator.entity.Project;
import com.luomengan.code.generator.pojo.DataObjectPojo;
import com.luomengan.code.generator.util.FreeMakerUtil;

public class SkeletonGeneratorService {

	public static final String backFtlDir = "/ftl/back";
	public static final String frontFtlDir = "/ftl/front";
	public static final String backSkeletonDir = "/skeleton/back";
	public static final String frontSkeletonDir = "/skeleton/front";

	/**
	 * 代码目录
	 */
	private File codeDirFile;
	/**
	 * 项目根目录
	 */
	private File projectDirFile;
	/**
	 * src java代码根目录
	 */
	private File javaDir;
	/**
	 * src resource资源根目录
	 */
	private File resourcesDir;
	/**
	 * test java代码根目录
	 */
	private File testJavaDir;
	/**
	 * src java代码主包目录
	 */
	private File basePackageDir;
	/**
	 * test java代码主包目录
	 */
	private File testBasePackageDir;
	/**
	 * 前端代码主目录
	 */
	private File frontDirFile;

	public SkeletonGeneratorService(String codeDir) {
		this.codeDirFile = new File(codeDir);
		if (!codeDirFile.exists()) {
			codeDirFile.mkdirs();
		}
	}

	private void generateDir(String projectName, String basePackage) {
		// 项目根目录
		projectDirFile = new File(codeDirFile, projectName);
		if (!projectDirFile.exists()) {
			projectDirFile.mkdirs();
		}
		// 项目重要目录
		javaDir = new File(projectDirFile, "src/main/java");
		resourcesDir = new File(projectDirFile, "src/main/resources");
		testJavaDir = new File(projectDirFile, "src/test/java");
		if (!javaDir.exists()) {
			javaDir.mkdirs();
		}
		if (!resourcesDir.exists()) {
			resourcesDir.mkdirs();
		}
		if (!testJavaDir.exists()) {
			testJavaDir.mkdirs();
		}
		// java主包
		basePackageDir = new File(javaDir, basePackage.replaceAll("\\.", "/"));
		if (!basePackageDir.exists()) {
			basePackageDir.mkdirs();
		}
		testBasePackageDir = new File(testJavaDir, basePackage.replaceAll("\\.", "/"));
		if (!testBasePackageDir.exists()) {
			testBasePackageDir.mkdirs();
		}
		// 前端代码主目录
		frontDirFile = new File(projectDirFile, "src/main/resources/static");
		if (!frontDirFile.exists()) {
			frontDirFile.mkdirs();
		}
	}

	private void generateBackSkeleton(Project project, List<DataObject> dataObjectList) {
		// step 1 : 构建freemarker的上下文
		Map<String, Object> projectRoot = new HashMap<>();
		projectRoot.put("mavenGroupId", project.getMavenGroupId());
		projectRoot.put("mavenArtifactId", project.getMavenArtifactId());
		projectRoot.put("mavenVersion", project.getMavenVersion());
		projectRoot.put("projectName", project.getName());
		projectRoot.put("projectDescription", project.getDescription());
		projectRoot.put("basePackage", project.getBasePackage());
		// step 2 : 生成后端目录
		generateDir(project.getName(), project.getBasePackage());
		// step 3 : 生成maven项目的基本脚手架
		FreeMakerUtil.generateFile(backFtlDir + "/archetype", "pom.ftl", projectRoot,
				new File(projectDirFile, "pom.xml"));
		FreeMakerUtil.generateFile(backFtlDir + "/archetype", "application.ftl", projectRoot,
				new File(resourcesDir, "application.properties"));
		// step 4 : 生成一些base类
		FreeMakerUtil.generateFile(backFtlDir + "/base", "BootApplication.ftl", projectRoot,
				new File(basePackageDir, "BootApplication.java"));
		FreeMakerUtil.generateFile(backFtlDir + "/base", "DataResponse.ftl", projectRoot,
				new File(basePackageDir, "pojo/DataResponse.java"));
		FreeMakerUtil.generateFile(backFtlDir + "/base", "SwaggerConfigration.ftl", projectRoot,
				new File(basePackageDir, "swagger/SwaggerConfigration.java"));
		FreeMakerUtil.generateFile(backFtlDir + "/base", "CommonalityEnum.ftl", projectRoot,
				new File(basePackageDir, "util/CommonalityEnum.java"));
		FreeMakerUtil.generateFile(backFtlDir + "/awre", "TransactionConfigure.ftl", projectRoot,
				new File(basePackageDir, "awre/TransactionConfigure.java"));
		FreeMakerUtil.generateFile(backFtlDir + "/awre/convertor", "ConverterConfiguration.ftl", projectRoot,
				new File(basePackageDir, "awre/convertor/ConverterConfiguration.java"));
		FreeMakerUtil.generateFile(backFtlDir + "/awre/convertor", "StringToDateConverter.ftl", projectRoot,
				new File(basePackageDir, "awre/convertor/StringToDateConverter.java"));
		FreeMakerUtil.generateFile(backFtlDir + "/awre/mvc", "WebMvcConfiguration.ftl", projectRoot,
				new File(basePackageDir, "awre/mvc/WebMvcConfiguration.java"));
		FreeMakerUtil.generateFile(backFtlDir + "/controller", "BaseControllerTest.ftl", projectRoot,
				new File(testBasePackageDir, "controller/BaseControllerTest.java"));
	}

	private void generateFrontSkeleton(Project project, List<DataObject> dataObjectList) throws IOException {
		// step 1 : 构建freemarker的上下文
		Map<String, Object> projectRoot = new HashMap<>();
		projectRoot.put("mavenGroupId", project.getMavenGroupId());
		projectRoot.put("mavenArtifactId", project.getMavenArtifactId());
		projectRoot.put("mavenVersion", project.getMavenVersion());
		projectRoot.put("projectName", project.getName());
		projectRoot.put("projectDescription", project.getDescription());
		projectRoot.put("basePackage", project.getBasePackage());
		projectRoot.put("adminWebTitle", project.getAdminWebTitle());
		projectRoot.put("adminWebMetaDescription", project.getAdminWebMetaDescription());
		projectRoot.put("dataObjectPojoList", DataObjectPojo.getPojoList(dataObjectList));
		// step 2 : 复制前端骨架
		File frontSkeletonDirFile = new File("src/main/resources" + frontSkeletonDir);
		FileUtils.copyDirectory(frontSkeletonDirFile, frontDirFile);
		// step 3 : 生成index.html
		FreeMakerUtil.generateFile(frontFtlDir, "index_html.ftl", projectRoot, new File(frontDirFile, "index.html"));
		// step 4 : 生成app.js
		FreeMakerUtil.generateFile(frontFtlDir + "/js", "app_js.ftl", projectRoot,
				new File(frontDirFile + "/js", "app.js"));
		// step 5 : 生成config.router.js
		FreeMakerUtil.generateFile(frontFtlDir + "/js", "config.router_js.ftl", projectRoot,
				new File(frontDirFile + "/js", "config.router.js"));
		// step 6 : 生成nav.html
		FreeMakerUtil.generateFile(frontFtlDir + "/tpl/blocks", "nav.ftl", projectRoot,
				new File(frontDirFile + "/tpl/blocks", "nav.html"));
	}

	public void generateSkeleton(Project project, List<DataObject> dataObjectList) throws IOException {
		generateDir(project.getName(), project.getBasePackage());
		generateBackSkeleton(project, dataObjectList);
		generateFrontSkeleton(project, dataObjectList);
	}

	public File getCodeDirFile() {
		return codeDirFile;
	}

	public void setCodeDirFile(File codeDirFile) {
		this.codeDirFile = codeDirFile;
	}

	public File getProjectDirFile() {
		return projectDirFile;
	}

	public void setProjectDirFile(File projectDirFile) {
		this.projectDirFile = projectDirFile;
	}

	public File getJavaDir() {
		return javaDir;
	}

	public void setJavaDir(File javaDir) {
		this.javaDir = javaDir;
	}

	public File getResourcesDir() {
		return resourcesDir;
	}

	public void setResourcesDir(File resourcesDir) {
		this.resourcesDir = resourcesDir;
	}

	public File getTestJavaDir() {
		return testJavaDir;
	}

	public void setTestJavaDir(File testJavaDir) {
		this.testJavaDir = testJavaDir;
	}

	public File getBasePackageDir() {
		return basePackageDir;
	}

	public void setBasePackageDir(File basePackageDir) {
		this.basePackageDir = basePackageDir;
	}

	public File getTestBasePackageDir() {
		return testBasePackageDir;
	}

	public void setTestBasePackageDir(File testBasePackageDir) {
		this.testBasePackageDir = testBasePackageDir;
	}

	public File getFrontDirFile() {
		return frontDirFile;
	}

	public void setFrontDirFile(File frontDirFile) {
		this.frontDirFile = frontDirFile;
	}

}
