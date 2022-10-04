package com.demo_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class DemoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration()
	{

		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.demo_jpa.controller")).build().apiInfo(apiDetails());

	}

	private ApiInfo apiDetails()
	{

		return new ApiInfo("Jpa Test", "Api Documentation", "1.0", "Jpa Test", new springfox.documentation.service.Contact("", "", ""), "", "", Collections.emptyList());
	}

}
