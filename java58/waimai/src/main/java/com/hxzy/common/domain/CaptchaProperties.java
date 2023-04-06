package com.hxzy.common.domain;

import com.hxzy.common.constants.WaiMaiConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/6-0:45
 * @description TODO
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
