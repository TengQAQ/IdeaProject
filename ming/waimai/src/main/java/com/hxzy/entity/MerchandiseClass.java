package com.hxzy.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 商品分类表
 * @TableName MERCHANDISE_CLASS
 */
@Data
public class MerchandiseClass implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 商家id
     */
    private BigDecimal mId;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 口味图片
     */
    private String picture;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateBy;

    private static final long serialVersionUID = 1L;

}