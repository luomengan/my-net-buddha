package com.luomengan.code.generator.pojo;

import java.util.ArrayList;
import java.util.List;

import com.luomengan.code.generator.entity.DataObject;

public class DataObjectPojo extends DataObject {

	/**
	 * 生成的js文件名
	 */
	private String jsName;

	/**
	 * 驼峰名称
	 */
	private String humpName;

	/**
	 * 数据库表名
	 */
	private String dbTableName;

	public DataObjectPojo(DataObject dataObject) {
		this.setDescription(dataObject.getDescription());
		this.setId(dataObject.getId());
		this.setName(dataObject.getName());
		this.setManageIcon(dataObject.getManageIcon());
		this.setJsName(getDataObjectJsName(dataObject.getName()));
		this.setHumpName(getDataObjectHumpName(dataObject.getName()));
		this.setDbTableName(getDataObjectEntityTableName(dataObject.getName()));
	}

	public String getJsName() {
		return jsName;
	}

	public void setJsName(String jsName) {
		this.jsName = jsName;
	}

	public String getHumpName() {
		return humpName;
	}

	public void setHumpName(String humpName) {
		this.humpName = humpName;
	}

	public String getDbTableName() {
		return dbTableName;
	}

	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	public static DataObjectPojo getPojo(DataObject dataObject) {
		return new DataObjectPojo(dataObject);
	}

	public static List<DataObjectPojo> getPojoList(List<DataObject> dataObjectList) {
		List<DataObjectPojo> result = new ArrayList<>();
		for (DataObject dataObject : dataObjectList) {
			result.add(new DataObjectPojo(dataObject));
		}
		return result;
	}

	public static String getDataObjectJsName(String dataObjectName) {
		StringBuilder tableName = new StringBuilder();
		for (int i = 0; i < dataObjectName.length(); i++) {
			if (dataObjectName.charAt(i) >= 65 && dataObjectName.charAt(i) <= 90) {
				if (i > 0) {
					tableName.append("-" + String.valueOf(dataObjectName.charAt(i)).toLowerCase());
				} else {
					tableName.append(String.valueOf(dataObjectName.charAt(i)).toLowerCase());
				}
			} else {
				tableName.append(dataObjectName.charAt(i));
			}
		}
		return tableName.toString();
	}

	public static String getDataObjectHumpName(String dataObjectName) {
		return String.valueOf(dataObjectName.charAt(0)).toLowerCase() + dataObjectName.substring(1);
	}

	public static String getDataObjectEntityTableName(String dataObjectName) {
		StringBuilder tableName = new StringBuilder();
		for (int i = 0; i < dataObjectName.length(); i++) {
			if (dataObjectName.charAt(i) >= 65 && dataObjectName.charAt(i) <= 90) {
				tableName.append("_" + String.valueOf(dataObjectName.charAt(i)).toLowerCase());
			} else {
				tableName.append(dataObjectName.charAt(i));
			}
		}
		return tableName.toString();
	}

}
