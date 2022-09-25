package com.mca.similarproducts.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfig.
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Api docket.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket apiDocket() {

		List<Response> listReponse = new ArrayList<>();

		listReponse.add(new ResponseBuilder().code("404").description("Product Not Found").build());

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mca.similarproducts.controller"))
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo()).useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, listReponse);
	}

	/**
	 * Gets the api info.
	 *
	 * @return the api info
	 */
	private ApiInfo getApiInfo() {

		return new ApiInfoBuilder().title("Similar Products").description("API Endpoint Similar Products")
				.contact(new Contact("Dev-Team", "https://www.dev-team.com/", "dev-team@gmail.com"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0")
				.build();

	}
}
