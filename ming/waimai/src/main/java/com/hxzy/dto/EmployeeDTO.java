package com.hxzy.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/23-20:42
 * @description TODO
 */
@ApiModel(value = "新增后台员工信息")
@Getter
@Setter
@ToString
public class EmployeeDTO {
    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为空")
    private BigDecimal id;
    /**
     * 登录账户
     */
    @ApiModelProperty(value = "登录账户")
    @NotBlank(message = "登录账户不能为空")
    @Length(min = 1,max = 50,message = "账户的长度在1-50个字符之间")
    private String loginName;

    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码")
    @NotBlank(message = "登录密码不能为空")
    @Length(min = 4,max = 20,message = "密码长度在4-20个字符之间")
    private String loginPwd;

    /**
     * 确认密码
     */
    @ApiModelProperty(value = "确认密码")
    @NotBlank(message = "确认密码不能为空")
    private String loginPwdConfirm;

    /**
     * 性别(0 女 1 男)
     */
    @ApiModelProperty(value = "性别(0 女 1 男)")
    @NotNull(message = "性别不能为空")
    private Short gender;

    /**
     * 状态（1停用，0正常）
     */
    @ApiModelProperty(value = "状态（1停用，0正常）")
    @NotNull(message = "状态不能为空")
    private Short status;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @NotBlank(message = "头像不能为空")
    @Length(min = 1,max = 500,message = "头像地址长度不能超过500个字符")
    private String avatar;
}
