package com.chaossnow.ms.Swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chaos
 * @ClassName SwaggerConfig
 * @date 2022年08月07日 23:26
 * @Version 1.0
 */

//在SpringBoot项目中可以写成
//@Configuration
//@EnableSwagger2
@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = "com.chaossnow.ms.controller")
public class SwaggerConfig {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商业银行信用卡风险管理系统 API Documentation")
                .description("服务:权限管理，用户管理，校色管理，权限管理，日志 后台")
                .license("")
                .version("1.0.0")
                .build();
    }
}
