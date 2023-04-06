package com.ming.entity;

import java.io.Serializable;

/**
 * 
 * @TableName goods_photo
 */
public class GoodsPhoto implements Serializable {
    /**
     * 主键。自增长
     */
    private Integer id;

    /**
     * 商品id
     */
    private GoodsInfo goodsInfo;

    /**
     * 图片url
     */
    private String goodsImg;

    /**
     * 预留字段
     */
    private String value1;

    private static final long serialVersionUID = 1L;

    /**
     * 主键。自增长
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键。自增长
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 商品id
     */
    public GoodsInfo getGoodsId() {
        return goodsInfo;
    }

    /**
     * 商品id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsInfo = goodsInfo;
    }

    /**
     * 图片url
     */
    public String getGoodsImg() {
        return goodsImg;
    }

    /**
     * 图片url
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    /**
     * 预留字段
     */
    public String getValue1() {
        return value1;
    }

    /**
     * 预留字段
     */
    public void setValue1(String value1) {
        this.value1 = value1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsPhoto)) return false;

        GoodsPhoto that = (GoodsPhoto) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GoodsPhoto{" +
                "id=" + id +
                ", goodsInfo=" + goodsInfo +
                ", goodsImg='" + goodsImg + '\'' +
                ", value1='" + value1 + '\'' +
                '}';
    }
}