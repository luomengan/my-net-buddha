package com.luomengan.entity.dbconverter;

import javax.persistence.AttributeConverter;

import com.luomengan.entity.dbenum.OfferingTypeEnum;

/**
 * 性别类型转换器
 * 
 * @author luomengan
 *
 */
public class OfferingTypeEnumConverter implements AttributeConverter<OfferingTypeEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(OfferingTypeEnum attribute) {
		return attribute.getIndex();
	}

	@Override
	public OfferingTypeEnum convertToEntityAttribute(Integer dbData) {
		return OfferingTypeEnum.getByIndex(dbData);
	}

}
