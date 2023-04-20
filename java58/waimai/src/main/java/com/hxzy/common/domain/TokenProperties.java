package com.hxzy.common.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author wy
 * @Description 令牌属性
 * @Date 2023/4/6 9:12
 * @Version 1.0
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
