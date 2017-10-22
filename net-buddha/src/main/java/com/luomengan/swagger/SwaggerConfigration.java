package com.luomengan.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigration {

	@Bean
	public Docket createRestApi() {
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6IlJvbGVfQXBwLCIsInVzZXJJZCI6MSwibmFtZSI6Iue9l-aipuWuiSIsImlzQWRtaW4iOmZhbHNlLCJzdWIiOiIxMzkyODk1MjI1NCIsImV4cCI6NDMyMDAwMTUwODQ4MjMyM30.5_OWSeWkSWb3t_5bUSYPvU3aRXjjcx_p8k1hp7UwjHVhVN10onUTlgxWxSBMCYbuhwrKcRISLPth8QagOR6leg";
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		tokenPar.name("Authorization").description("token令牌").modelRef(new ModelRef("string")).parameterType("header")
				.defaultValue(token).required(false).build();
		pars.add(tokenPar.build());

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).globalOperationParameters(pars).select()
				.apis(RequestHandlerSelectors.basePackage("com.luomengan.controller")).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("luomengan", "http://luomengan.com:9090/net-buddha/", "");
		return new ApiInfoBuilder().title("").contact(contact).version("1.0").build();
	}

}