package com.luomengan.code.generator.awre.mvc;

import java.text.SimpleDateFormat;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luomengan.code.generator.awre.convertor.DateConverter;
import com.luomengan.code.generator.awre.convertor.UniversalEnumConverterFactory;

/**
 * web mvc配置
 * 
 * @author luomengan
 *
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		super.addFormatters(registry);
		registry.addConverterFactory(new UniversalEnumConverterFactory());
		registry.addConverter(new DateConverter());
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
				ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/403.html");
				container.addErrorPages(error401Page, error403Page);
			}
		};
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		return objectMapper;
	}

}
