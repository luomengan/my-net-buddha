package com.luomengan.code.generator.awre.convertor;

import javax.persistence.AttributeConverter;

import com.luomengan.code.generator.util.enums.ManageTypeEnum;

/**
 * 数据管理类型 转换器
 * 
 * @author luomengan
 *
 */
public class ManageTypeEnumConverter implements AttributeConverter<ManageTypeEnum, Integer> {

	/**
	 * 将枚举类型转换成数据库字段值
	 */
	@Override
	public Integer convertToDatabaseColumn(ManageTypeEnum attribute) {
		return attribute.getIndex();
	}

	/**
	 * 将数据库字段值转换成枚举
	 */
	@Override
	public ManageTypeEnum convertToEntityAttribute(Integer dbData) {
		return ManageTypeEnum.getByIndex(dbData);
	}
}
