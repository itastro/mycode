package cn.shengrui.common.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class AllFilter implements Filter {
    private String[] excludedUris;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info("进入all拦截器");

        HttpSession session = request.getSession();
        String url = request.getRequestURI();
        log.info(url);
        String originHeader = request.getHeader("Origin");
        log.info(originHeader);

        response.setHeader("Access-Control-Allow-Origin",originHeader );
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token,Authorization,SessionToken");
        response.setHeader("Access-Control-Expose-Headers", "*");
        if (request.getMethod().equals(RequestMethod.OPTIONS.toString())) {

            filterChain.doFilter(request, response);
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.print("过滤器被销毁了");
    }


}
