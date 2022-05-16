package com.example.GuideCane.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class SwaggerConfig {

    @Value("${springfox.documentation.swagger-ui.enabled}")
    private boolean enabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(
                DocumentationType.OAS_30)
                .enable(enabled)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/error.*").negate())
                .paths(PathSelectors.regex("/actuator.*").negate())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("G9 TW Backend")
                .description("G9 TW Backend API Socket")
                .version("0.0.1")
                .license("MIT LICENSE 2.0")
                .licenseUrl("https://github.com/aven910126")
                .contact(new Contact("Aven", "https://github.com/aven910126", "b10923003@gemail.yuntech.edu.tw"))
                .build();
    }

}
