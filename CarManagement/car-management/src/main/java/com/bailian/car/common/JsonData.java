package com.bailian.car.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回Json数据
 * 
 * @创建人 bailian
 * @创建时间 2018年1月12日上午10:19:06
 * @修改人 wang
 * @修改时间 2018年1月12日上午10:19:06
 * @since JDK 1.8
 */
@Getter
@Setter
public class JsonData implements Serializable {

	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();
	/**
	 * serialVersionUID:序列化.
	 */
	private static final long serialVersionUID = -170165854210801205L;

	private boolean ret; // 返回结果

	private String msg; // 消息

	private Object data;// 数据


	public JsonData(boolean ret) {
		super();
		this.ret = ret;
	}

	public JsonData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonData(boolean ret, String msg, Object data) {
		super();
		this.ret = ret;
		this.msg = msg;
		this.data = data;
	}

	public static JsonData build(Boolean ret, String msg, Object data) {
		return new JsonData(ret, msg, data);
	}

	public static JsonData build(Boolean ret, String msg) {
		return new JsonData(ret, msg, null);
	}

	public static JsonData success(Object object) {
		JsonData jsonData = new JsonData(true);
		jsonData.data = object;
		return jsonData;
	}

	public static JsonData success(Object object, String msg) {

		JsonData jsonData = new JsonData(true);
		jsonData.data = object;
		jsonData.msg = msg;
		return jsonData;
	}

	public static JsonData success() {
		return new JsonData(true);

	}

	public static JsonData success(String msg) {
		JsonData jsonData = new JsonData(true);
		jsonData.msg = msg;
		return jsonData;

	}

	
	public static JsonData fail(Object object, String msg) {

		JsonData jsonData = new JsonData(false);
		jsonData.data = object;
		jsonData.msg = msg;
		return jsonData;

	}

	public static JsonData fail(String msg) {
		JsonData jsonData = new JsonData(false);
		jsonData.msg = msg;
		return jsonData;
	}

	public static JsonData error(String msg) {
		JsonData jsonData = new JsonData();
		jsonData.msg = msg;
		return jsonData;
	}

	public static JsonData fail() {
		return new JsonData(false);

	}

	public Map<String, Object> toMap() {

		HashMap<String, Object> result = new HashMap<>();

		result.put("ret", ret);
		result.put("msg", msg);
		result.put("data", data);
		return result;
	}

	/**
	* 将json结果集转化为CarResult对象
	* 
	* @param jsonData json数据
	* @param clazz CarResult中的object类型
	* @return
	*/
	public static JsonData formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, JsonData.class);
			}
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (clazz != null) {
				if (data.isObject()) {
					obj = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {
					obj = MAPPER.readValue(data.asText(), clazz);
				}
			}
			return build(jsonNode.get("ret").booleanValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 没有object对象的转化
	 * 
	 * @param json
	 * @return
	 */
	public static JsonData format(String json) {
		try {
			return MAPPER.readValue(json, JsonData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object是集合转化
	 * 
	 * @param jsonData json数据
	 * @param clazz 集合中的类型
	 * @return
	 */
	public static JsonData formatToList(String jsonData, Class<?> clazz) {
		try {
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (data.isArray() && data.size() > 0) {
				obj = MAPPER.readValue(data.traverse(),
						MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
			}
			return build(jsonNode.get("ret").booleanValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	
}
