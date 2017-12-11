package com.luomengan.entity.dbconverter;

import javax.persistence.AttributeConverter;

import com.luomengan.entity.dbenum.GenderEnum;

/**
 * 性别类型转换器
 * 
 * @author luomengan
 *
 */
public class GenderEnumConverter implements AttributeConverter<GenderEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(GenderEnum attribute) {
		return attribute.getIndex();
	}

	@Override
	public GenderEnum convertToEntityAttribute(Integer dbData) {
		return GenderEnum.getByIndex(dbData);
	}

}
