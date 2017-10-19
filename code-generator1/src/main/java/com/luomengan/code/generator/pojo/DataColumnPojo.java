package com.luomengan.code.generator.pojo;

import java.util.ArrayList;
import java.util.List;

import com.luomengan.code.generator.entity.DataColumn;

public class DataColumnPojo extends DataColumn {

	private String upName;

	public DataColumnPojo(DataColumn dataColumn) {
		this.setDescription(dataColumn.getDescription());
		this.setIsDisplayInTable(dataColumn.getIsDisplayInTable());
		this.setId(dataColumn.getId());
		this.setName(dataColumn.getName());
		this.setType(dataColumn.getType());
		this.setUpName(getDataColumnUpName(dataColumn.getName()));
	}

	public String getUpName() {
		return upName;
	}

	public void setUpName(String upName) {
		this.upName = upName;
	}

	public static DataColumnPojo getPojo(DataColumn dataColumn) {
		return new DataColumnPojo(dataColumn);
	}

	public static List<DataColumnPojo> getPojoList(List<DataColumn> dataColumnList) {
		List<DataColumnPojo> result = new ArrayList<>();
		for (DataColumn dataColumn : dataColumnList) {
			result.add(new DataColumnPojo(dataColumn));
		}
		return result;
	}

	public static String getDataColumnUpName(String dataColumnName) {
		return String.valueOf(dataColumnName.charAt(0)).toUpperCase() + dataColumnName.substring(1);
	}

}
