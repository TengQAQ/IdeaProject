package com.hxzy.common.domain;

import com.hxzy.common.constants.WaiMaiConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author wy
 * @Description 验证码的属性
 * @Date 2023/4/4 14:25
 * @Version 1.0
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "captcha")
public class CaptchaProperties {

    /**
     * 宽度
     */
    private Integer width=150;

    /**
     * 高度
     */
    private Integer height=48;

    /**
     * 长度
     */
    private Integer len=2;

    /**
     * 验证码类型  png/gif/airth
     */
    private String type= WaiMaiConstant.ARITHMETIC;
}
