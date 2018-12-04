package com.bailian.car.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.bailian.car.utils.JsonMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {
	private static final String START_TIME = "REQUEST_STARTTIME";
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		String url = request.getRequestURI().toString();

		Map<String, String[]> map = request.getParameterMap();
		log.info("url:{}", url, JsonMapper.obj2String(map));

		long start = System.currentTimeMillis();

		request.setAttribute(START_TIME, start);
     
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		String url = request.getRequestURI().toString();

		Map<String, String[]> map = request.getParameterMap();

		long s = (long) request.getAttribute(START_TIME);

		long e = System.currentTimeMillis();

		log.info("time:{}", e - s);

		log.info("url:{},params:{}", url, JsonMapper.obj2String(map));

		// removeThreadLocalInfo();
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		String url = request.getRequestURI().toString();

		Map<String, String[]> map = request.getParameterMap();
		long s = (long) request.getAttribute(START_TIME);

		long e = System.currentTimeMillis();
		log.info("url:{}", url, JsonMapper.obj2String(map));

		log.info("time:{}", e - s);
	}

}
