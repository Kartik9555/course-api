package io.javabrains.courseapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("io.javabrains.courseapi"))
				.paths(PathSelectors.regex("/course.*")).build().apiInfo(metadata());
	}
	
	private ApiInfo metadata() {
		ApiInfo apiInfo = new ApiInfo(
				"SPRING BOOT REST API",
				"SPRING BOOT REST API for TOPIC AND COURSE",
				"1.0",
				"Terms Of Service",
				new Contact("Kartikeshwar Kandpal", "www.photogapher.com", "kartik9555@gmail.com"),
				"Topic and Course Licence",
				"www.testLicenceurl.com");
		return apiInfo;
	}
}
