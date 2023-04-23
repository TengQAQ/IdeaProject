package com.hxzy.dto;

import com.hxzy.common.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/13-0:35
 * @description TODO
 */
@Getter
@Setter
@ToString
@ApiModel(value = "前端用户查询")
public class ContamerSearchDTO extends PageDto {


    @ApiModelProperty(value = "账号")
    private String loginid;


    @ApiModelProperty(value = "昵称")
    private String userName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间(yyyy-MM-dd)")
    private Date beginTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间(yyyy-MM-dd)")
    private Date endTime;
}
