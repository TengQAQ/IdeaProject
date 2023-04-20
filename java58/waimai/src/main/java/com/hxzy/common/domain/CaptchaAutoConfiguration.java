package com.hxzy.common.domain;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author wy
 * @Description TODO
 * @Date 2023/4/4 14:33
 * @Version 1.0
 */
@AutoConfiguration
@EnableConfigurationProperties({CaptchaProperties.class})
public class CaptchaAutoConfiguration {
}
