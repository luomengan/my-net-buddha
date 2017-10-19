package com.luomengan.code.generator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 项目 实体
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 项目名称
	 */
	private String name;

	/**
	 * 项目主包
	 */
	private String basePackage;

	/**
	 * 项目描述
	 */
	private String description;

	/**
	 * maven g
	 */
	private String mavenGroupId;

	/**
	 * maven a
	 */
	private String mavenArtifactId;

	/**
	 * maven v
	 */
	private String mavenVersion;

	/**
	 * 后台管理界面标题
	 */
	private String adminWebTitle;

	/**
	 * 后台管理界面网页描述原信息
	 */
	private String adminWebMetaDescription;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMavenGroupId() {
		return mavenGroupId;
	}

	public void setMavenGroupId(String mavenGroupId) {
		this.mavenGroupId = mavenGroupId;
	}

	public String getMavenArtifactId() {
		return mavenArtifactId;
	}

	public void setMavenArtifactId(String mavenArtifactId) {
		this.mavenArtifactId = mavenArtifactId;
	}

	public String getMavenVersion() {
		return mavenVersion;
	}

	public void setMavenVersion(String mavenVersion) {
		this.mavenVersion = mavenVersion;
	}

	public String getAdminWebTitle() {
		return adminWebTitle;
	}

	public void setAdminWebTitle(String adminWebTitle) {
		this.adminWebTitle = adminWebTitle;
	}

	public String getAdminWebMetaDescription() {
		return adminWebMetaDescription;
	}

	public void setAdminWebMetaDescription(String adminWebMetaDescription) {
		this.adminWebMetaDescription = adminWebMetaDescription;
	}

}
