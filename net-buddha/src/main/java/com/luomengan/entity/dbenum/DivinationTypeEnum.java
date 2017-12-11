package com.luomengan.entity.dbenum;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * 灵签类型
 * 
 * @author luomengan
 *
 */
public enum DivinationTypeEnum implements CommonalityEnum {

	UpUp(1, "上上签"),

	Up(2, "上签"),

	Middle(3, "中签"),

	Down(4, "下签"),

	DownDown(5, "下下签");

	private Integer index;
	private String type;

	DivinationTypeEnum(Integer index, String type) {
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

	private static Map<Integer, DivinationTypeEnum> valueMap = new HashMap<>();

	static {
		for (DivinationTypeEnum _enum : DivinationTypeEnum.values()) {
			valueMap.put(_enum.getIndex(), _enum);
		}
	}

	public static DivinationTypeEnum getByIndex(Integer index) {
		DivinationTypeEnum result = valueMap.get(index);
		if (result == null) {
			throw new IllegalArgumentException("No element matches " + index);
		}
		return result;
	}
}
