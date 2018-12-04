package com.bailian.car.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bailian.car.utils.TokenManagerUtils;

public class loginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("进入到系统拦截器");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		if (uri.indexOf("/login.action") >= 0) {
			chain.doFilter(req, rep);
			return;
		}
		if (uri.indexOf("/logintwo.action") >= 0) {
			chain.doFilter(req, rep);
			return;
		}
		if (uri.indexOf("/loginOut.action") >= 0) {
			chain.doFilter(req, rep);
			return;
		}
		if (TokenManagerUtils.getToken() == null) {
			request.getRequestDispatcher("/login.html").forward(request, response);
			return;
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
