package com.hxzy.common.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/6-13:54
 * @description TODO
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "token")
public class TokenProperties {
    /**
     * 过期时间
     */
    private Integer expiredMinutes;

    /**
     * jwt签名
     */
    private String sign;

    /**
     * 管理员登录令牌前缀标识
     */
    private String adminRedisPrefix="admin:token:";

    /**
     * 管理员令牌JWT前缀(持票人)
     */
    private String adminBear="Bearer";

    /**
     * 管理员请求头标识
     */
    private String adminHeader="Authorization";

    /**
     * 刷新令牌时间点
     */
    private Integer refreshToken=20;

}
