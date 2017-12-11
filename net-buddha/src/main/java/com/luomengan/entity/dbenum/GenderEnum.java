package com.luomengan.entity.dbenum;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * 性别
 * 
 * @author luomengan
 *
 */
public enum GenderEnum implements CommonalityEnum {

	Man(1, "男"),

	Female(2, "女");

	private Integer index;
	private String gender;

	GenderEnum(Integer index, String gender) {
		this.index = index;
		this.gender = gender;
	}

	@Override
	@JsonValue
	public Integer getIndex() {
		return index;
	}

	public String getGender() {
		return gender;
	}

	private static Map<Integer, GenderEnum> valueMap = new HashMap<>();

	static {
		for (GenderEnum _enum : GenderEnum.values()) {
			valueMap.put(_enum.getIndex(), _enum);
		}
	}

	public static GenderEnum getByIndex(Integer index) {
		GenderEnum result = valueMap.get(index);
		if (result == null) {
			throw new IllegalArgumentException("No element matches " + index);
		}
		return result;
	}
}
