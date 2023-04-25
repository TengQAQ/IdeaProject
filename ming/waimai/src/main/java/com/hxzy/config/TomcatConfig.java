package com.hxzy.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/23-22:06
 * @description 配置tomcat配置文件在方法中加入了 \"<>[\\]^`{|}这些符号，问题就这么完美的解决了
 * 我们在前后台交互的时候往往使用json格式的字段串参数，其中含有“{}”“[]”这些特舒符号，
 * 在高版本的tomcat中含有这些字符的请求会被拦截
 */
@Configuration
public class TomcatConfig {

    @Bean
    public TomcatServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((Connector connector) -> {
            connector.setProperty("relaxedPathChars", "\"<>[\\]^`{|}");
            connector.setProperty("relaxedQueryChars", "\"<>[\\]^`{|}");
        });
        return factory;
    }
}
