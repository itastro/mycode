package cn.shengrui.common.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @ClassName FileConfig
 * @Description TODO
 * @Date 2018/9/10 14:32
 * @Author itastro
 * @Version 1.0
 **/
@Configuration
public class FileConfig {


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize("200MB");
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("204800KB");
        return factory.createMultipartConfig();
    }
}
