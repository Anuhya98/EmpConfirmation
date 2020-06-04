package com.cts.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cts.employee"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiDetails());
	}
	@SuppressWarnings("unchecked")
	public ApiInfo apiDetails() {
		return new ApiInfo("EmployeeConfirmation API",
				"sample project",
				"1.0",
				"free to use",
				new springfox.documentation.service.Contact("Batch7AC", "xyz.com", "anuhya1898@gmail.com"),
				"API license",
				"http.abc.io",
				Collections.EMPTY_LIST);
	}
	

}
