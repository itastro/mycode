package com.bailian.car.handler;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.bailian.car.annotation.JSON;
import com.bailian.car.common.CustomerJsonSerializer;

public class JsonReturnHandler implements HandlerMethodReturnValueHandler {

	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		// 如果有我们自定义的 JSON 注解 就用我们这个Handler 来处理
		boolean hasJsonAnno = returnType.getMethodAnnotation(JSON.class) != null;
		return hasJsonAnno;
	}

	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest) throws Exception {
		// 设置这个就是最终的处理类了，处理完不再去找下一个类进行处理
		mavContainer.setRequestHandled(true);

		// 获得注解并执行filter方法 最后返回
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		Annotation[] annos = returnType.getMethodAnnotations();
		CustomerJsonSerializer jsonSerializer = new CustomerJsonSerializer();
		Arrays.asList(annos).forEach(a -> {
			if (a instanceof JSON) {
				JSON json = (JSON) a;
				jsonSerializer.filter(json.type(), json.include(), json.filter());
			}
		});

		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		String json = jsonSerializer.toJson(returnValue);
		response.getWriter().write(json);
	}
}
