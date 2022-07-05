package com.mediScreenDemoGraphics;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MediScreenDemoGraphicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediScreenDemoGraphicsApplication.class, args);
	}
	@Bean 
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("com.mediScreenDemoGraphics.controller"))
				.build()
				.apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "MediScreenDemoGraphics API", 
	      "an api for taking personal details of patients.", 
	      "API TOS", 
	      "Terms of service", 
	      new Contact("Oghoro Ogheneakpobo", " https://bobdazzler.github.io/myPortfolio/", "oghorobob93@gmail.com.com"), 
	      "License of API", "API license URL", Collections.emptyList());
}
}
