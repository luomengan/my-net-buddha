package com.luomengan.awre.mvc;

import java.io.File;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luomengan.awre.mvc.convertor.StringToDateConverter;
import com.luomengan.awre.mvc.convertor.UniversalEnumConverterFactory;

/**
 * web mvc配置
 * 
 * @author luomengan
 *
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Value("${custom.outer.resources}")
	private String outerResources;

	@Override
	public void addFormatters(FormatterRegistry registry) {
		super.addFormatters(registry);
		registry.addConverterFactory(new UniversalEnumConverterFactory());
		registry.addConverter(new StringToDateConverter());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		File dir = new File(outerResources);
		if (dir.exists()) {
			File[] files = dir.listFiles();
			if (files != null && files.length > 0) {
				for (File file : files) {
					if (file.isDirectory()) {
						String fileName = file.getName();
						String fileDir = "file:" + outerResources + fileName + "/";
						registry.addResourceHandler("/" + fileName + "/**").addResourceLocations(fileDir);
					}
				}
			}
		}
		super.addResourceHandlers(registry);
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
