package com.luomengan.awre.mvc.convertor;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.luomengan.entity.dbenum.CommonalityEnum;

/**
 * 通用的枚举转换工厂类
 * 
 * @author luomengan
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
public class UniversalEnumConverterFactory implements ConverterFactory<Integer, CommonalityEnum> {

	public static final Map<Class, Converter> converterMap = new WeakHashMap<>();

	@Override
	public <T extends CommonalityEnum> Converter<Integer, T> getConverter(Class<T> targetType) {
		Converter result = converterMap.get(targetType);
		if (result == null) {
			result = new IntegerToEnum<>(targetType);
			converterMap.put(targetType, result);
		}
		return result;
	}

	class IntegerToEnum<T extends CommonalityEnum> implements Converter<Integer, T> {
		private final Class<T> enumType;
		private Map<Integer, T> enumMap = new HashMap<>();

		public IntegerToEnum(Class<T> enumType) {
			this.enumType = enumType;
			T[] enums = enumType.getEnumConstants();
			for (T e : enums) {
				enumMap.put(e.getIndex(), e);
			}
		}

		@Override
		public T convert(Integer source) {
			T result = enumMap.get(source);
			if (result == null) {
				throw new IllegalArgumentException("No element matches " + source);
			}
			return result;
		}
	}
}
