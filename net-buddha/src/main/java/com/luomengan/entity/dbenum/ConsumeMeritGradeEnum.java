package com.luomengan.entity.dbenum;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * 功德累计消耗等级
 * 
 * @author luomengan
 *
 */
public enum ConsumeMeritGradeEnum implements CommonalityEnum {

	Grade1(1, 2000, "等级一"),

	Grade2(2, 7000, "等级二"),

	Grade3(3, 12000, "等级三"),

	Grade4(4, 32000, "等级四"),

	Grade5(5, 60000, "等级五");

	private Integer index;
	private Integer meritValue;
	private String name;

	ConsumeMeritGradeEnum(Integer index, Integer meritValue, String name) {
		this.index = index;
		this.meritValue = meritValue;
		this.name = name;
	}

	@Override
	@JsonValue
	public Integer getIndex() {
		return index;
	}

	public Integer getMeritValue() {
		return meritValue;
	}

	public void setMeritValue(Integer meritValue) {
		this.meritValue = meritValue;
	}

	public String getName() {
		return name;
	}

	private static Map<Integer, ConsumeMeritGradeEnum> valueMap = new HashMap<>();

	static {
		for (ConsumeMeritGradeEnum _enum : ConsumeMeritGradeEnum.values()) {
			valueMap.put(_enum.getIndex(), _enum);
		}
	}

	public static ConsumeMeritGradeEnum getByIndex(Integer index) {
		ConsumeMeritGradeEnum result = valueMap.get(index);
		if (result == null) {
			throw new IllegalArgumentException("No element matches " + index);
		}
		return result;
	}
}
