package com.bl.station.filters;


import com.bl.station.entity.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author itastro
 */
@Slf4j
public class LoginFilter implements Filter {


    private String[] excludedUris;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String exclusions = filterConfig.getInitParameter("exclusions");
        excludedUris = exclusions.split(",");

        log.info("进入登陆拦截器");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("进入loginFilter拦截器");
        log.info(((HttpServletRequest) servletRequest).getRequestURI());
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        boolean flag = false;
        HttpSession session = request.getSession();
        String url = request.getRequestURI();

        if (isExcludedUri(url)) {
            filterChain.doFilter(request, response);
        } else {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                filterChain.doFilter(request, response);
            } else {
                response.getWriter().print("you need login");

            }
        }
    }

    @Override
    public void destroy() {
        System.out.print("过滤器被销毁了");
    }

    /**
     * 判断url是否被拦截
     *
     * @param uri
     * @return
     */
    private boolean isExcludedUri(String uri) {
        if (excludedUris == null || excludedUris.length <= 0) {
            return false;
        }
        for (String ex : excludedUris) {
            uri = uri.trim();
            ex = ex.trim();
            if (uri.toLowerCase().matches(ex.toLowerCase())) {
                return true;
            } else if (uri.toLowerCase().contains(ex.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
