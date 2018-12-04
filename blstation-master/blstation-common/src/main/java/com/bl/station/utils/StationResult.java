package com.bl.station.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class StationResult implements Serializable {

	/**
	 * 定义jackson对象
	 */
	private static final ObjectMapper MAPPER = new ObjectMapper();
	/**
	 * serialVersionUID:序列化.
	 */
	private static final long serialVersionUID = -170165854210801205L;
	/**
	 * 返回结果
	 */
	private boolean ret;
	/**
	 * 信息
	 */
	private String msg;
	/**
	 * 数据
	 */
	private Object data;


	public StationResult(boolean ret) {
		super();
		this.ret = ret;
	}

	public StationResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StationResult(boolean ret, String msg, Object data) {
		super();
		this.ret = ret;
		this.msg = msg;
		this.data = data;
	}

	public static StationResult build(Boolean ret, String msg, Object data) {
		return new StationResult(ret, msg, data);
	}

	public static StationResult build(Boolean ret, String msg) {
		return new StationResult(ret, msg, null);
	}

	public static StationResult success(Object object) {
		StationResult stationResult = new StationResult(true);
		stationResult.data = object;
		return stationResult;
	}

	public static StationResult success(Object object, String msg) {

		StationResult stationResult = new StationResult(true);
		stationResult.data = object;
		stationResult.msg = msg;
		return stationResult;
	}

	public static StationResult success() {
		return new StationResult(true);

	}

	public static StationResult success(String msg) {
		StationResult stationResult = new StationResult(true);
		stationResult.msg = msg;
		return stationResult;

	}

	
	public static StationResult fail(Object object, String msg) {

		StationResult stationResult = new StationResult(false);
		stationResult.data = object;
		stationResult.msg = msg;
		return stationResult;

	}

	public static StationResult fail(String msg) {
		StationResult stationResult = new StationResult(false);
		stationResult.msg = msg;
		return stationResult;
	}

	public static StationResult error(String msg) {
		StationResult stationResult = new StationResult();
		stationResult.msg = msg;
		return stationResult;
	}

	public static StationResult fail() {
		return new StationResult(false);

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
	public static StationResult formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, StationResult.class);
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
	public static StationResult format(String json) {
		try {
			return MAPPER.readValue(json, StationResult.class);
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
	public static StationResult formatToList(String jsonData, Class<?> clazz) {
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
