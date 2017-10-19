package com.luomengan.awre.convertor;

import javax.persistence.AttributeConverter;

import com.luomengan.util.enums.FavouriteTypeEnum;

/**
 * 收藏类型转换器
 * 
 * @author luomengan
 *
 */
public class FavouriteTypeEnumConverter implements AttributeConverter<FavouriteTypeEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(FavouriteTypeEnum attribute) {
		return attribute.getIndex();
	}

	@Override
	public FavouriteTypeEnum convertToEntityAttribute(Integer dbData) {
		return FavouriteTypeEnum.getByIndex(dbData);
	}

}
