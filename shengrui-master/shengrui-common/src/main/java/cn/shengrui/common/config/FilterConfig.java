package cn.shengrui.common.config;

import cn.shengrui.common.filters.XssAndSqlFilter;
import cn.shengrui.common.filters.AllFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * @author itastro
 */
@Configuration
public class FilterConfig {


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

    @Bean
    public FilterRegistrationBean shiroFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        //该值缺省为false，表示生命周期由SpringApplicationContext管理，设置为true则表示由ServletContainer管理
        registration.addInitParameter("targetFilterLifecycle", "true");
        registration.setEnabled(true);
        registration.setOrder(Integer.MAX_VALUE - 1);
        registration.addUrlPatterns("/*");
        return registration;
    }
}
