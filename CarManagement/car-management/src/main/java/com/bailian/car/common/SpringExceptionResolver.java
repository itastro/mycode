package com.bailian.car.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.bailian.car.exception.ParamException;
import com.bailian.car.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName: SpringExceptionResolver
 * @Description: 全局异常处理
 * @author itastro
 * @date 2017年12月15日
 *
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String url = request.getRequestURI().toString();
		ModelAndView mv;
		String defaultMsg = "System error";
		if (ex instanceof PermissionException || ex instanceof ParamException) {
			JsonData result = JsonData.fail(ex.getMessage());
			mv = new ModelAndView("jsonView", result.toMap());
			return mv;
		} else {
			log.error("unknow json exception,url:" + url, ex);
			JsonData result = JsonData.fail(defaultMsg);
			mv = new ModelAndView("jsonView", result.toMap());
		}
		return mv;
	}

}
