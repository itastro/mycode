package cn.shengrui.common.beans;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JsonResult
 * @Description TODO
 * @Date 2018/10/7 17:29
 * @Author itastro
 * @Version 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {

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
    private Integer code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data = new Object();


    public JsonResult(Integer code) {
        super();
        this.code = code;
    }

    public JsonResult(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public static JsonResult fail(String msg, Object object) {

        return new JsonResult(0, msg, object);
    }


    public static JsonResult success(String msg, Object object) {

        return new JsonResult(1, msg, object);
    }

    public static JsonResult fail(String msg) {

        return new JsonResult(0, msg);
    }


    public static JsonResult success(String msg) {
        return new JsonResult(1, msg);
    }


    public static JsonResult fail() {
        return new JsonResult(0);
    }


    public static JsonResult success() {
        return new JsonResult(1);
    }


    public static JsonResult build(Integer code, String msg, Object data) {
        return new JsonResult(code, msg, data);
    }

    public static JsonResult build(Integer code, String msg) {
        return new JsonResult(0, msg, null);
    }

    public Map<String, Object> toMap() {

        HashMap<String, Object> result = new HashMap<>();

        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    /**
     * 将json结果集转化为CarResult对象
     *
     * @param jsonData json数据
     * @param clazz    CarResult中的object类型
     * @return
     */
    public static JsonResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, JsonResult.class);
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
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
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
    public static JsonResult format(String json) {
        try {
            return MAPPER.readValue(json, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz    集合中的类型
     * @return
     */
    public static JsonResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

}
