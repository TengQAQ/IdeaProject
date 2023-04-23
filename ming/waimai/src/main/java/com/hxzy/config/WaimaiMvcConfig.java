package com.hxzy.config;

import com.hxzy.config.interceptor.BackTokenValidatorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/7-1:30
 * @description TODO
 */
@Configuration
public class WaimaiMvcConfig implements WebMvcConfigurer {

    /**
     * 后台拦截，拦截所有的/api/**
     */
    @Autowired
    private BackTokenValidatorInterceptor backTokenValidatorInterceptor;


    /**
     * 添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(this.backTokenValidatorInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/login","/api/captcha");


    }

    /**
     * 静态资源放行
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
