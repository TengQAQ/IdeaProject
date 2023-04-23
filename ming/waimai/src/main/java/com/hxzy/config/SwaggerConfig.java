package com.hxzy.config;


import com.hxzy.common.domain.SwaggerProperties;
import io.lettuce.core.dynamic.support.ReflectionUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/7-1:38
 * @description TODO
 */


/**
 * @author rongrong
 * @version 1.0
 * @description Swagger3配置
 * @date 2021/01/12 21:00
 */
@Configuration
/**
 * @EnableSwagger2 swagger3版本不需要使用这个注解，当然写上也无所谓~
 */
public class SwaggerConfig implements WebMvcConfigurer {
    /**
     * @Description: 在Spring框架中，有一个名为Docket的类，它用于配置和构建Swagger的API文档。
     * Swagger是一个用于描述和呈现RESTful API的框架，可以帮助开发人员和终端用户更好地了解和使用API
     * 在Spring中，Docket类可以用来创建一个Swagger文档对象，该对象包含API的详细信息，例如API的名称、描述、版本号、接口地址等等。
     * 通过配置Docket对象，开发人员可以自定义Swagger文档的内容和格式，例如添加请求头、响应模型等等。
     * Docket类是Springfox框架中的一部分，该框架使用Swagger规范创建API文档，帮助开发人员构建高质量的RESTful API。
     * Docket类提供了一种简单而灵活的方式来配置和生成Swagger文档，使开发人员可以轻松地为他们的API添加文档。
     **/

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                // 设置安全模式，swagger可以设置访问token
                .securityContexts(Arrays.asList(SecurityContext.builder()
                        .securityReferences(Arrays.asList(SecurityReference.builder()
                                .reference("Authorization")
                                .scopes(new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")})
                                .build(),SecurityReference.builder()
                                .reference("UserAccessInfo")
                                .scopes(new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")})
                                .build()))
                        .build()))
                .securitySchemes(Arrays.asList(new ApiKey("Authorization", "Authorization", "header"),
                        new ApiKey("UserAccessInfo", "UserAccessInfo", "header")))
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo()).enable(true)
                // 设置哪些接口暴露给Swagger展示
                .select()
                //apis： 添加swagger接口提取范围. 扫描所有有注解的api，用这种方式更灵活 《1》
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 扫描指定包中的swagger注解 .apis(RequestHandlerSelectors.basePackage("com.maoyou.project.tool.swagger"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("xxx管理平台")
                .description("xxx管理平台 API接口文档")
                .license("xxx有限公司")
                .licenseUrl("xxx")
                .version("1.0")
                .build();
    }

}