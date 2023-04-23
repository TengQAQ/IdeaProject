package com.hxzy.vo.back;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/6-10:21
 * @description TODO
 */
@Getter
@Setter
@ToString
public class AdminLoginVO {
    private BigDecimal id;

    /**
     * 名称
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 账号类型（1-管理员, 2-代表商家）
     */
    private Integer accountType;

    /**
     * 令牌
     */
    private String token;

    /**
     * 令牌过期时间(给令牌续时)
     */
    private Date expiredTime;

}
