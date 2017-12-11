package com.luomengan.entity.dbconverter;

import javax.persistence.AttributeConverter;

import com.luomengan.entity.dbenum.RatingTypeEnum;

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
