package com.luomengan.entity.dbconverter;

import javax.persistence.AttributeConverter;

import com.luomengan.entity.dbenum.MeritFlowTypeEnum;

/**
 * 评分类型转换器
 * 
 * @author luomengan
 *
 */
public class MeritFlowTypeEnumConverter implements AttributeConverter<MeritFlowTypeEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(MeritFlowTypeEnum attribute) {
		return attribute.getIndex();
	}

	@Override
	public MeritFlowTypeEnum convertToEntityAttribute(Integer dbData) {
		return MeritFlowTypeEnum.getByIndex(dbData);
	}

}
