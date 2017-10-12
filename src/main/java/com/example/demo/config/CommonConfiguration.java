package com.example.demo.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is a Common Configuration Class
 * 
 * @author VPillai
 * @version 1.0
 */
@EnableSwagger2
@Configuration
public class CommonConfiguration {

	/**
	 * Method for getting H2 Console access in Spring Boot Tomcat is embedded so
	 * web.xml is not accessible this help to get ServletRegistrationBean to get
	 * console access
	 * 
	 * @return ServletRegistrationBean
	 */
	@Bean
	protected ServletRegistrationBean h2servletRegistration() {
		final ServletRegistrationBean registrationBean = new ServletRegistrationBean(
				new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}

	/**
	 * Swagger2 Configuration Docket is required with Base package and url parameter
	 * @return Docket
	 */
	@Bean
	public Docket studentApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo"))
				.paths(PathSelectors.any()).build().apiInfo(metaData());
	}

	/**
	 * Necessary Swagger2 Api Information
	 * @return ApiInfo
	 */
	private ApiInfo metaData() {
		return new ApiInfo("Spring Boot REST API",
				"Spring Boot REST API for Student Data - Vinod Pillai", "1.0",
				"Terms of service", new Contact("Vinod Pillai",
						"https://springframework.guru/about/",
						"vinodthebest@gmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0");

	}

}
