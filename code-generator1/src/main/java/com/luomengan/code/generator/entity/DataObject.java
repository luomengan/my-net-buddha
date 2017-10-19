package com.luomengan.code.generator.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.luomengan.code.generator.awre.convertor.ManageTypeEnumConverter;
import com.luomengan.code.generator.util.enums.ManageTypeEnum;

/**
 * 数据对象 实体
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_data_object")
public class DataObject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 数据管理类型
	 */
	@Column(name = "manage_type")
	@Convert(converter = ManageTypeEnumConverter.class)
	private ManageTypeEnum manageType;

	/**
	 * 数据管理图标
	 */
	@Column(name = "manage_icon")
	private String manageIcon;

	/**
	 * 对应的项目
	 */
	@ManyToOne
	@JoinColumn(name = "p_id")
	private Project project;

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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ManageTypeEnum getManageType() {
		return manageType;
	}

	public void setManageType(ManageTypeEnum manageType) {
		this.manageType = manageType;
	}

	public String getManageIcon() {
		return manageIcon;
	}

	public void setManageIcon(String manageIcon) {
		this.manageIcon = manageIcon;
	}

}
