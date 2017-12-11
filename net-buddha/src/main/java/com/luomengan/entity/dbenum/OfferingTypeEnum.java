package com.luomengan.entity.dbenum;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * 供品类型
 * 
 * @author luomengan
 *
 */
public enum OfferingTypeEnum implements CommonalityEnum {

	Sandalwood(1, "檀香"), Fruit(2, "水果"), Flower(3, "鲜花");

	private Integer index;
	private String type;

	OfferingTypeEnum(Integer index, String type) {
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

	private static Map<Integer, OfferingTypeEnum> valueMap = new HashMap<>();

	static {
		for (OfferingTypeEnum _enum : OfferingTypeEnum.values()) {
			valueMap.put(_enum.getIndex(), _enum);
		}
	}

	public static OfferingTypeEnum getByIndex(Integer index) {
		OfferingTypeEnum result = valueMap.get(index);
		if (result == null) {
			throw new IllegalArgumentException("No element matches " + index);
		}
		return result;
	}
}
