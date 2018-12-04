package com.bailian.car.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(this.apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.bailian.car")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()

				.title("测试开放API接口文档")

				.description("一个测试的接口文档")

				.version("0.0.1")

				.termsOfServiceUrl("www.baidu.com")

				.license("LICENSE")

				.licenseUrl("www.baidu.com")

				.contact(new Contact("java程序员", "", ""))

				.build();

	}

}