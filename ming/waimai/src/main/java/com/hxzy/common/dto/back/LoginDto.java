package com.hxzy.common.dto.back;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/6-10:25
 * @description TODO
 */
@Getter
@Setter
@ToString
public class LoginDto {

    /**
     * 登录账户
     */
    @NotBlank(message = "登录账户不能为空")
    private String loginName;

    /**
     * 登录密码
     */
    @NotBlank(message = "登录密码不能为空")
    private String loginPwd;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String code;

    /**
     * 验证码在redis中存放的标识
     */
    @NotBlank(message = "验证码标识不能为空")
    private String uuid;
}
