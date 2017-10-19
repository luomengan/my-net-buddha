package com.luomengan.util.enums;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 收藏类型枚举
 * 
 * @author luomengan
 *
 */
public enum FavouriteTypeEnum implements CommonalityEnum {

	Other(0, "其他"),

	Music(1, "音乐"),

	MusicCategory(2, "音乐专辑");

	private Integer index;
	private String type;

	FavouriteTypeEnum(Integer index, String type) {
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

	private static Map<Integer, FavouriteTypeEnum> valueMap = new HashMap<>();

	static {
		for (FavouriteTypeEnum _enum : FavouriteTypeEnum.values()) {
			valueMap.put(_enum.getIndex(), _enum);
		}
	}

	public static FavouriteTypeEnum getByIndex(Integer index) {
		FavouriteTypeEnum result = valueMap.get(index);
		if (result == null) {
			throw new IllegalArgumentException("No element matches " + index);
		}
		return result;
	}
}
