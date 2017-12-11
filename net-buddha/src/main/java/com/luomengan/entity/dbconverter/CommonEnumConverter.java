package com.luomengan.entity.dbconverter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

import javax.persistence.AttributeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通用枚举类型转换器
 * 
 * @author luomengan
 *
 * @param <T>
 *            枚举类型
 */
@SuppressWarnings("unchecked")
public class CommonEnumConverter<T> implements AttributeConverter<T, Integer> {

	Logger logger = LoggerFactory.getLogger(getClass());

	private Class<T> genericClazz = null;
	{
		genericClazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	private Method getIndexMethod() {
		try {
			return genericClazz.getMethod("getIndex");
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException("The getIndex method not exist?");
		}
	}

	private Method getByIndexMethod() {
		try {
			return genericClazz.getMethod("getByIndex", Integer.class);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException("The getByIndex method not exist?");
		}
	}

	@Override
	public Integer convertToDatabaseColumn(T enumData) {
		try {
			return (Integer) getIndexMethod().invoke(enumData);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException("The getIndex method invoke failed! The enumData is " + enumData + ".");
		}
	}

	@Override
	public T convertToEntityAttribute(Integer indexData) {
		try {
			return (T) getByIndexMethod().invoke(null, indexData);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException("The getByIndex method invoke failed! The indexData is " + indexData + ".");
		}
	}

}
