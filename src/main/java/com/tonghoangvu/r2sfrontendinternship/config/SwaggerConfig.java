package com.tonghoangvu.r2sfrontendinternship.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
	@Bean
	public UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder()
			.tagsSorter(TagsSorter.ALPHA)
			.operationsSorter(OperationsSorter.METHOD)
			.build();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.useDefaultResponseMessages(false)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
			"R2S frontend internship",
			"R2S frontend internship project",
			"1.0.0",
			"/",
			new Contact(
				"Tong Hoang Vu",
				"https://github.com/tonghoangvu",
				"tonghoangvu@outlook.com"),
			"MIT",
			"https://github.com/tonghoangvu/r2s-frontend-internship/blob/main/LICENSE",
			Collections.emptyList());
	}
}
