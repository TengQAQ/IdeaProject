package com.hxzy.common.dto;


import com.hxzy.config.WaimaiThreadLocal;
import com.hxzy.vo.back.AdminLoginVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 通用接收分页参数
 */
@Getter
@Setter
@ApiModel(value = "分页模型")
public class PageDTO {

    @ApiModelProperty(value = "当前几第页",required = true,example = "1")
    private Integer  page;

    @ApiModelProperty(value = "每页显示几笔",required = true,example = "10")
    private Integer size;


    /**
     * 商家ID
     */
    @ApiModelProperty( value = "商家ID",hidden = true)
    private BigDecimal tenantId;

    /**
     * 得到商家ID
     * @return
     */
    public BigDecimal getTenantId() {
        AdminLoginVO adminLoginVO = WaimaiThreadLocal.adminThreadLocal.get();
        if(adminLoginVO!=null && adminLoginVO.getAccountType()==2){
            return adminLoginVO.getId();
        }
        return tenantId;
    }


}
