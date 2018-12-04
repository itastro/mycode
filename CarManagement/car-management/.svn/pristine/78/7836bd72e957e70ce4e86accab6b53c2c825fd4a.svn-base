package com.bailian.car.utils;

import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * 可以把一个类转换成一个json字符串
 * 
 * @描述 可以把一个类转换成一个json字符串
 * @创建人 bailian
 * @创建时间 2018年1月12日上午9:57:59
 * @修改人 wang
 * @修改时间 2018年1月12日上午9:57:59
 * @since JDK 1.8
 */
@Slf4j // 日志记录
public class JsonUtils {

	private static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 
	 * 转换成string类型
	 * 
	 * @方法名 objectToJson
	 * @param src
	 * @return
	 * @返回类型 String
	 * @创建人 bailian
	 * @创建时间 2018年1月12日上午10:09:15
	 * @修改人 wang
	 * @修改时间 2018年1月12日上午10:09:15
	 */
	public static <T> String objectToJson(T src) {

		if (src == null) {
			return null;
		}

		try {
			return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
		} catch (Exception e) {
			// TODO: handle exception
			log.warn("parse object to string exception, error:{}", "e");
			return null;
		}
	}

	/**
	 * 
	 * string 类型转换成Object类型
	 * 
	 * @方法名 jsonToObject
	 * @param src
	 * @param typeReference
	 * @return
	 * @返回类型 T
	 * @创建人 bailian
	 * @创建时间 2018年1月12日上午10:16:38
	 * @修改人 wang
	 * @修改时间 2018年1月12日上午10:16:38
	 */
	public static <T> T jsonToObject(String src, TypeReference<T> typeReference) {

		if (src == null || typeReference == null) {
			return null;
		}
		try {
			@SuppressWarnings("unchecked")
			T t = (T) (typeReference.getType().equals(String.class) ? src : objectMapper.readValue(src, typeReference));
			return t;

		} catch (Exception e) {
			// TODO: handle exception
			log.warn("parse String to object exception ,String:{} , TypeReference<T>:{} , error:{}", src,
					typeReference);
			return null;
		}
	}

	/**
	 * 
	 * 将Json数据转换成对象List
	 * @方法名 jsonToList
	 * @param src
	 * @param typeReference
	 * @return
	 * @返回类型 List<T>
	 * @创建人 bailian
	 * @创建时间 2018年1月12日上午11:04:52
	 * @修改人 wang
	 * @修改时间 2018年1月12日上午11:04:52
	 */
	public static <T> List<T> jsonToList(String src, TypeReference<T> typeReference) {
		if (src == null || typeReference == null) {
			return null;
		}

		try {
			@SuppressWarnings("unchecked")
			List<T> list = (List<T>) (typeReference.getType().equals(String.class) ? src
					: objectMapper.readValue(src, typeReference));
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
}
