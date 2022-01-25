package com.prueba.consultorio.infraestructura.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.prueba.consultorio.infraestructura"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Consultorio","Api prueba de ingreso HELISA", "1.0","",new Contact("Elios Nieto", "", "eliosnieto17@hotmail.com"),
                "","", Collections.emptyList()
        );
    }

}
