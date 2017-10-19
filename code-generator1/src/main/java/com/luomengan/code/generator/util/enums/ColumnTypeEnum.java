package com.luomengan.code.generator.util.enums;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 数据列类型 枚举
 * 
 * @author luomengan
 *
 */
public enum ColumnTypeEnum implements CommonalityEnum {

	Varchar(1, "字符"),

	Integer(2, "整数"),

	Long(3, "长整数"),

	Double(4, "双精度浮点数"),

	Boolean(5, "布尔"),

	Date(6, "日期"),

	Emum(7, "枚举"),
	
	SelfTree(8, "自身树");

	private Integer index;
	private String type;

	ColumnTypeEnum(Integer index, String type) {
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

	private static Map<Integer, ColumnTypeEnum> valueMap = new HashMap<>();

	static {
		for (ColumnTypeEnum _enum : ColumnTypeEnum.values()) {
			valueMap.put(_enum.getIndex(), _enum);
		}
	}

	public static ColumnTypeEnum getByIndex(Integer index) {
		ColumnTypeEnum result = valueMap.get(index);
		if (result == null) {
			throw new IllegalArgumentException("No element matches " + index);
		}
		return result;
	}
}
