package com.bailian.car.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;
/**
 * 
    * @ClassName: JsonpAdvice
    * @Description: 自定义判断json/jsonp请求 ，动态返回数据
    * @author itastro
    * @date 2018年2月2日
    *
 */
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

	private final String[] jsonpQueryParamNames;

	public JsonpAdvice() {
		super("jsonpCallback", "jsonp");
		this.jsonpQueryParamNames = new String[] { "jsonpCallback" };
	}

	@Override
	protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType,
			MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
		// TODO Auto-generated method stub
		HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
		// 如果不存在callback这个请求参数，直接返回，不需要处理为jsonp
		if (ObjectUtils.isEmpty(servletRequest.getParameter("jsonpCallback"))) {
			return;

		}
		// 按设定的请求参数(JsonAdvice构造方法中的this.jsonpQueryParamNames = new
		// String[]{"jsonpCallback"};)，处理返回结果为jsonp格式

		for (String name : this.jsonpQueryParamNames) {
			String value = servletRequest.getParameter(name);
			if (value != null) {
				MediaType contentTypeToUse = getContentType(contentType, request, response);
				response.getHeaders().setContentType(contentTypeToUse);
				bodyContainer.setJsonpFunction(value);
				return;
			}
		}
	}

}
