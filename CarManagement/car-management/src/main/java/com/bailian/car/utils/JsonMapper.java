package com.bailian.car.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * 可以把一个类转换成一个json字符串 
 * @ClassName: JsonMapper
 * @Description: json转换工具类
 * @author itastro
 * @date 2017年12月16日
 *
 */

@Slf4j // 日志的记录
public class JsonMapper {
	private static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 
	* @Title: obj2String  
	* @Description: object 类型转化成json
	* @param @param src
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	public static <T> String obj2String(T src) {
		if (src == null) {
			return null;
		}
		try {
			return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
		} catch (Exception e) {
			// TODO: handle exception
			log.warn("parse object to string exception, error:{}", e);
			return null;

		}
	}

	/**
	 * 
	 * @Title: string2Object  
	 * @Description: json 转成Object
	 * @param @param src
	 * @param @param typeReference
	 * @param @return    参数  
	 * @return T    返回类型  
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static <T> T string2Object(String src, TypeReference<T> typeReference) {

		if (src == null || typeReference == null) {
			return null;
		}
		try {
			return (T) (typeReference.getType().equals(String.class) ? src
					: objectMapper.readValue(src, typeReference));
		} catch (Exception e) {
			log.warn("parse String to object exception ,String:{} , TypeReference<T>:{} , error:{}", src,
					typeReference);
			return null;

		}

	}
}