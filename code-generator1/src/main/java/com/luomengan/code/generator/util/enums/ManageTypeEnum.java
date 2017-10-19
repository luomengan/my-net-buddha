package com.luomengan.code.generator.util.enums;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 数据管理类型 枚举
 * 
 * @author luomengan
 *
 */
public enum ManageTypeEnum implements CommonalityEnum {

	Basic(1, "基本管理"),

	SelfTree(2, "自身树管理"),

	OtherTree(3, "基于其他树管理"),
	
	OtherList(4, "基于其他列表管理");

	private Integer index;
	private String type;

	ManageTypeEnum(Integer index, String type) {
		this.index = index;
		this.type = type;
	}

	@Override
	public Integer getIndex() {
		return index;
	}

	@JsonValue
	public String getType() {
		return type;
	}

	private static Map<Integer, ManageTypeEnum> valueMap = new HashMap<>();

	static {
		for (ManageTypeEnum _enum : ManageTypeEnum.values()) {
			valueMap.put(_enum.getIndex(), _enum);
		}
	}

	public static ManageTypeEnum getByIndex(Integer index) {
		ManageTypeEnum result = valueMap.get(index);
		if (result == null) {
			throw new IllegalArgumentException("No element matches " + index);
		}
		return result;
	}
}
