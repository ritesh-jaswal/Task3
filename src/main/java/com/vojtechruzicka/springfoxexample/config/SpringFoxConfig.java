package com.vojtechruzicka.springfoxexample.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@EnableOpenApi
@Import(BeanValidatorPluginsConfiguration.class)
@PropertySource("classpath:swagger.properties")
public class SpringFoxConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vojtechruzicka"))
                .paths(PathSelectors.ant("/v2/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "SpringFox Demo Application",
                "This application demonstrates documenting os Spring Boot app with Swagger using SpringFox.",
                "1.0.0",
                "TERMS OF SERVICE URL",
                new Contact("Vojtech Ruzicka", "http://www.vojtechruzicka.com", "vojtech.ruz@gmail.com"),
                "MIT License",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
