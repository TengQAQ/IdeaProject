package com.hxzy.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/5/3-16:27
 * @description TODO
 */
@Getter
@Setter
@ToString
@ApiModel(value = "商家注册验证码")
public class ShopRegisterSMSDTO {
    @NotBlank(message = "验证码不能为空")
    private String code;

    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^0?(13|15|17|18|14|19)[0-9]{9}$",message = "手机号码格式不正确，只支持(13|14|15|17|18|19)开头的")
    private String phone;
}
