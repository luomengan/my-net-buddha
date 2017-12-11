package com.luomengan.entity.dbconverter;

import javax.persistence.AttributeConverter;

import com.luomengan.entity.dbenum.DivinationTypeEnum;

/**
 * 灵签类型转换器
 * 
 * @author luomengan
 *
 */
public class DivinationTypeEnumConverter implements AttributeConverter<DivinationTypeEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(DivinationTypeEnum attribute) {
		return attribute.getIndex();
	}

	@Override
	public DivinationTypeEnum convertToEntityAttribute(Integer dbData) {
		return DivinationTypeEnum.getByIndex(dbData);
	}

}
