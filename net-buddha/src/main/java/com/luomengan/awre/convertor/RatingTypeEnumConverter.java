package com.luomengan.awre.convertor;

import javax.persistence.AttributeConverter;

import com.luomengan.util.enums.RatingTypeEnum;

/**
 * 评分类型转换器
 * 
 * @author luomengan
 *
 */
public class RatingTypeEnumConverter implements AttributeConverter<RatingTypeEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(RatingTypeEnum attribute) {
		return attribute.getIndex();
	}

	@Override
	public RatingTypeEnum convertToEntityAttribute(Integer dbData) {
		return RatingTypeEnum.getByIndex(dbData);
	}

}
