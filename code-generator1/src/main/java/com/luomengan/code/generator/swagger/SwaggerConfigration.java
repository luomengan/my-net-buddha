package com.luomengan.code.generator.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
public class SwaggerConfigration {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.luomengan.code.generator.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("luomengan", "http://localhost:8080/code-generator/", "493671072@qq.com");
		return new ApiInfoBuilder().title("代码生成器Api").contact(contact).version("1.0").build();
	}

}