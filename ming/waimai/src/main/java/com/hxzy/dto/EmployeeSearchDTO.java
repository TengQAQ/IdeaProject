package com.hxzy.dto;

import com.hxzy.common.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/12-23:41
 * @description TODO
 */
@Getter
@Setter
@ToString
@ApiModel(value = "员工分页查询模型")
public class EmployeeSearchDTO  extends PageDto {

    @ApiModelProperty(value = "登录账户")
    private String loginName;


    @ApiModelProperty(value = "状态（1停用，0正常）")
    private Short status;
}
