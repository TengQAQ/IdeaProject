package com.hxzy.dto;

import com.hxzy.common.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
* @Author wy
* @Description 商品分类表查询
* @Date 2023-04-27
* @Version 1.0
*/
@Getter
@Setter
@ToString
@ApiModel(value = "商品分类表查询")
public class MerchandiseClassSearchDTO extends PageDto {

    @ApiModelProperty(value = "商家编号",hidden = true)
    private BigDecimal mId;

    @ApiModelProperty(value = "类别名称")
    private String  name;
}
