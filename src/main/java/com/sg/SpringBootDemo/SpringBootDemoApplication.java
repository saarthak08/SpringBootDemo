package com.sg.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		//return a prepared Docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/ac/*"))
				.apis(RequestHandlerSelectors.basePackage("com.sg.SpringBootDemo"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails()
	{
		return new ApiInfoBuilder().title("Aliens API").description("Spring Boot Demo Project")
				.version("1.0")
				.license("API License")
				.contact(new springfox.documentation.service.Contact("Saarthak Gupta","www.github.com/saarthak08","saarthakgupta08@gmail.com"))
				.build();
	}
}
