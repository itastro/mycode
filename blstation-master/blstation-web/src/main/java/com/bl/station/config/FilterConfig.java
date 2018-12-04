package com.bl.station.config;

import com.bl.station.filters.AllFilter;
import com.bl.station.filters.LoginFilter;
import com.bl.station.filters.XssAndSqlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author itastro
 */
@Configuration
public class FilterConfig {


    @Bean

    public FilterRegistrationBean filterRegBean() {

        String s = ",";
        StringBuffer exclusions = new StringBuffer();

        exclusions.append("/blstation-web").append(s);
        //登录
        exclusions.append("/blstation-web/user/login").append(s);
        //验证码
        exclusions.append("/blstation-web/user/defaultKaptcha").append(s);
        //留言添加
        exclusions.append("/blstation-web/leavemessage/add").append(s);
        //swagger-ui.html
        exclusions.append("/blstation-web/swagger-ui.html").append(s);
        exclusions.append("/blstation-web/webjars").append(s);
        exclusions.append("/blstation-web/swagger-resources/configuration/ui").append(s);
        exclusions.append("/blstation-web/swagger-resources").append(s);
        exclusions.append("/blstation-web/v2/api-docs").append(s);
        //banner
        exclusions.append("/blstation-web/findAll").append(s);
        //carousel
        exclusions.append("/blstation-web/findAll").append(s);
        //honner
        exclusions.append("/blstation-web/findAll").append(s);
        exclusions.append("/blstation-web/findById").append(s);
        //information
        exclusions.append("/blstation-web/findAll").append(s);
        exclusions.append("/blstation-web/findById").append(s);
        //item
        exclusions.append("/blstation-web/findById").append(s);
        exclusions.append("/blstation-web/findAll").append(s);
        //itemcat
        exclusions.append("/blstation-web/findItemCatById").append(s);
        exclusions.append("/blstation-web/list").append(s);
        //job
        exclusions.append("/blstation-web/findAll").append(s);
        exclusions.append("/blstation-web/findById").append(s);
        //new
        exclusions.append("/blstation-web/findAll").append(s);
        exclusions.append("/blstation-web/findById").append(s);
        //Case
        exclusions.append("/blstation-web/findById").append(s);
        exclusions.append("/blstation-web/findById").append(s);

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        LoginFilter loginFilter = new LoginFilter();
        registrationBean.setFilter(loginFilter);
        //拦截规则
        registrationBean.addUrlPatterns("/*");
        //设置初始化参数
        registrationBean.addInitParameter("exclusions", exclusions.toString());
        //设置过滤器名称
        registrationBean.setName("loginFilter");
        //设置级别
        registrationBean.setOrder(3);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filter2RegBean() {

        StringBuffer exclusions = new StringBuffer();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        AllFilter allFilter = new AllFilter();
        registrationBean.setFilter(allFilter);
        //拦截规则
        registrationBean.addUrlPatterns("/*");

        registrationBean.setName("allFilter");
        registrationBean.setOrder(2);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filter3RegBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        XssAndSqlFilter xssAndSqlFilter = new XssAndSqlFilter();

        registrationBean.setFilter(xssAndSqlFilter);
        //拦截规则
        registrationBean.addUrlPatterns("/*");

        registrationBean.setName("xssAndSqlFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
