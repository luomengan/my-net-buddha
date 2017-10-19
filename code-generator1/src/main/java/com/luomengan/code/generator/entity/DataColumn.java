package com.luomengan.code.generator.entity;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.luomengan.code.generator.awre.convertor.ColumnTypeEnumConverter;
import com.luomengan.code.generator.util.enums.ColumnTypeEnum;

/**
 * 数据列 实体
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_data_column")
public class DataColumn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 类型
	 */
	@Convert(converter = ColumnTypeEnumConverter.class)
	private ColumnTypeEnum type;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 是否在管理表格中显示
	 */
	private boolean isDisplayInTable;

	/**
	 * 对应的数据对象
	 */
	@ManyToOne
	@JoinColumn(name = "do_id")
	private DataObject dataObject;

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

	public ColumnTypeEnum getType() {
		return type;
	}

	public void setType(ColumnTypeEnum type) {
		this.type = type;
	}

	public DataObject getDataObject() {
		return dataObject;
	}

	public void setDataObject(DataObject dataObject) {
		this.dataObject = dataObject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsDisplayInTable() {
		return isDisplayInTable;
	}

	public void setIsDisplayInTable(boolean isDisplayInTable) {
		this.isDisplayInTable = isDisplayInTable;
	}

}
