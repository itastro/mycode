package com.bl.station.filters;

import com.bl.station.wrapper.XssAndSqlHttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class XssAndSqlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("XssAndSqlFilter执行了");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        XssAndSqlHttpServletRequestWrapper xssRequest = new XssAndSqlHttpServletRequestWrapper((HttpServletRequest) request);
        log.info("进入XSS拦截器");

        filterChain.doFilter(xssRequest, response);
    }

    @Override
    public void destroy() {
        log.info("XssAndSqlFilter销毁了");

    }
}
