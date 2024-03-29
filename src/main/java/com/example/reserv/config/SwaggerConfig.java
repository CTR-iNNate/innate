package com.example.reserv.config;

import org.springframework.web.context.support.HttpRequestHandlerServlet;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {

    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.reserv"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());




    }

    private ApiInfo apiInfo() {

    return new ApiInfoBuilder()
            .title("Reserv")
            .description("매장 예약")
            .version("1.0")
            .build();


    }
}
