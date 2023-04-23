package com.hxzy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis配置文件
 * @author QinTeng
 */
@Configuration
// 没有这个注解，mybatis使用一定报错
@MapperScan(basePackages = "com.hxzy.mapper")
public class MybatisConfig {
}
