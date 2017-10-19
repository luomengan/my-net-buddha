package com.luomengan.code.generator.awre.convertor;

import javax.persistence.AttributeConverter;

import com.luomengan.code.generator.util.enums.ColumnTypeEnum;

/**
 * 数据列类型 转换器
 * 
 * @author luomengan
 *
 */
public class ColumnTypeEnumConverter implements AttributeConverter<ColumnTypeEnum, Integer> {

	/**
	 * 将枚举类型转换成数据库字段值
	 */
	@Override
	public Integer convertToDatabaseColumn(ColumnTypeEnum attribute) {
		return attribute.getIndex();
	}

	/**
	 * 将数据库字段值转换成枚举
	 */
	@Override
	public ColumnTypeEnum convertToEntityAttribute(Integer dbData) {
		return ColumnTypeEnum.getByIndex(dbData);
	}
}
