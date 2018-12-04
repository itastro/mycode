package cn.shengrui.common.filters;

import cn.shengrui.common.enums.ResultEnum;
import cn.shengrui.common.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j

public class MyShiroFilter extends FormAuthenticationFilter {


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        boolean allowed = super.isAccessAllowed(request, response, mappedValue);
        if (!allowed) {
            // 判断请求是否是options请求
            String method = WebUtils.toHttp(request).getMethod();
            if (StringUtils.equalsIgnoreCase("OPTIONS", method)) {
                return true;
            }
        }
        return allowed;

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {


        HttpServletRequest req = (HttpServletRequest) request;

        String uri = req.getRequestURI();

        // 获取当前登录
        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {
            log.info("当前未登录！！");
            // 使用response响应流返回数据到前台（因前端需要接受json数据，注意前后端跨域问题）
            HttpServletResponse res = (HttpServletResponse) response;
            response.setContentType("text/html;charset=utf-8");
            res.setStatus(403);

            //throw new SystemException(ResultEnum.NOLOGIN_ERROR);
            return false;
        }
        return true;

    }
}
