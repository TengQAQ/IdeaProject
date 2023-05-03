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
 * @date 2023/5/3-16:19
 * @description TODO
 */
@Getter
@Setter
@ToString
@ApiModel(value = "商家信息查询")
public class MerchandiserSearchDTO extends PageDto {

    @ApiModelProperty(value = "商家名称")
    private String  name;

    /**
     * 审核状态（0已审核，1未审核）
     */
    @ApiModelProperty(value = "审核状态（0已审核，1未审核）")
    private Short status;


}