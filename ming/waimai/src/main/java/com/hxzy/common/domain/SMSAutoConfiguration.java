package com.hxzy.common.domain;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/5/3-15:40
 * @description TODO
 */
@AutoConfiguration
@EnableConfigurationProperties({SMSProperties.class})
public class SMSAutoConfiguration {
}
