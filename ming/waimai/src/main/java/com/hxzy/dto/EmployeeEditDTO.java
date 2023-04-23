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
 * @Author wy
 * @Description 修改用户
 * @Date 2023/4/14 14:04
 * @Version 1.0
 */
@ApiModel(value = "修改后台员工信息")
@Getter
@Setter
@ToString
public class EmployeeEditDTO {

    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为空")
    private BigDecimal id;

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
