package com.hxzy.common.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/5/3-15:39
 * @description TODO
 */
@ConfigurationProperties( prefix = "sms")
@Getter
@Setter
public class SMSProperties {

    /**
     * 认证ID
     */
    private String secretId;

    /**
     * 认证的密钥
     */
    private String secretKey;

    /**
     * 签名
     */
    private String signName;

    /**
     * 应用程序ID
     */
    private String sdkAppId;

    /**
     * 短信过期时间
     */
    private Integer expired;
}
