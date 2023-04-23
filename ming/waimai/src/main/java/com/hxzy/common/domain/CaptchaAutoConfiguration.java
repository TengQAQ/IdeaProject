package com.hxzy.common.domain;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/6-0:54
 * @description TODO
 */
@AutoConfiguration
@EnableConfigurationProperties({CaptchaProperties.class})
public class CaptchaAutoConfiguration {
}
