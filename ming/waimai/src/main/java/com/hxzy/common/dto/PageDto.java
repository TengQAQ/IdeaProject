package com.hxzy.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/5-17:56
 * @description TODO
 */

@Getter
@Setter
@ToString
public class PageDto {
    @ApiModelProperty(value = "当前第几页",required = true,example = "1")
    private int pageNum = 1;
    @ApiModelProperty(value = "当前第几页",required = true,example = "10")
    private int PageSize = 5;
}
