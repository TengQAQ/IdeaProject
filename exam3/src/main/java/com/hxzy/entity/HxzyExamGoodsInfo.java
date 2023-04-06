package com.hxzy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName hxzy_exam_goods_info
 */
public class HxzyExamGoodsInfo implements Serializable {
    /**
     * 商品表主键id
     */
    private Long goodsId;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 商品简介
     */
    private String goodsIntro;

    /**
     * 关联分类id
     */
    private Long goodsCategoryId;

    /**
     * 商品主图
     */
    private String goodsCoverImg;

    /**
     * 商品轮播图
     */
    private String goodsCarousel;

    /**
     * 商品详情
     */
    private String goodsDetailContent;

    /**
     * 商品价格
     */
    private Integer originalPrice;

    /**
     * 商品实际售价
     */
    private Integer sellingPrice;

    /**
     * 商品库存数量
     */
    private Object stockNum;

    /**
     * 商品标签
     */
    private String tag;

    /**
     * 商品上架状态 1-下架 0-上架
     */
    private Integer goodsSellStatus;

    /**
     * 添加者主键id
     */
    private Integer createUser;

    /**
     * 商品添加时间
     */
    private Date createTime;

    /**
     * 修改者主键id
     */
    private Integer updateUser;

    /**
     * 商品修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 商品表主键id
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * 商品表主键id
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 商品名
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 商品名
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 商品简介
     */
    public String getGoodsIntro() {
        return goodsIntro;
    }

    /**
     * 商品简介
     */
    public void setGoodsIntro(String goodsIntro) {
        this.goodsIntro = goodsIntro;
    }

    /**
     * 关联分类id
     */
    public Long getGoodsCategoryId() {
        return goodsCategoryId;
    }

    /**
     * 关联分类id
     */
    public void setGoodsCategoryId(Long goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    /**
     * 商品主图
     */
    public String getGoodsCoverImg() {
        return goodsCoverImg;
    }

    /**
     * 商品主图
     */
    public void setGoodsCoverImg(String goodsCoverImg) {
        this.goodsCoverImg = goodsCoverImg;
    }

    /**
     * 商品轮播图
     */
    public String getGoodsCarousel() {
        return goodsCarousel;
    }

    /**
     * 商品轮播图
     */
    public void setGoodsCarousel(String goodsCarousel) {
        this.goodsCarousel = goodsCarousel;
    }

    /**
     * 商品详情
     */
    public String getGoodsDetailContent() {
        return goodsDetailContent;
    }

    /**
     * 商品详情
     */
    public void setGoodsDetailContent(String goodsDetailContent) {
        this.goodsDetailContent = goodsDetailContent;
    }

    /**
     * 商品价格
     */
    public Integer getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 商品价格
     */
    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 商品实际售价
     */
    public Integer getSellingPrice() {
        return sellingPrice;
    }

    /**
     * 商品实际售价
     */
    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * 商品库存数量
     */
    public Object getStockNum() {
        return stockNum;
    }

    /**
     * 商品库存数量
     */
    public void setStockNum(Object stockNum) {
        this.stockNum = stockNum;
    }

    /**
     * 商品标签
     */
    public String getTag() {
        return tag;
    }

    /**
     * 商品标签
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * 商品上架状态 1-下架 0-上架
     */
    public Integer getGoodsSellStatus() {
        return goodsSellStatus;
    }

    /**
     * 商品上架状态 1-下架 0-上架
     */
    public void setGoodsSellStatus(Integer goodsSellStatus) {
        this.goodsSellStatus = goodsSellStatus;
    }

    /**
     * 添加者主键id
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 添加者主键id
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * 商品添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 商品添加时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改者主键id
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改者主键id
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 商品修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 商品修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HxzyExamGoodsInfo other = (HxzyExamGoodsInfo) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsIntro() == null ? other.getGoodsIntro() == null : this.getGoodsIntro().equals(other.getGoodsIntro()))
            && (this.getGoodsCategoryId() == null ? other.getGoodsCategoryId() == null : this.getGoodsCategoryId().equals(other.getGoodsCategoryId()))
            && (this.getGoodsCoverImg() == null ? other.getGoodsCoverImg() == null : this.getGoodsCoverImg().equals(other.getGoodsCoverImg()))
            && (this.getGoodsCarousel() == null ? other.getGoodsCarousel() == null : this.getGoodsCarousel().equals(other.getGoodsCarousel()))
            && (this.getGoodsDetailContent() == null ? other.getGoodsDetailContent() == null : this.getGoodsDetailContent().equals(other.getGoodsDetailContent()))
            && (this.getOriginalPrice() == null ? other.getOriginalPrice() == null : this.getOriginalPrice().equals(other.getOriginalPrice()))
            && (this.getSellingPrice() == null ? other.getSellingPrice() == null : this.getSellingPrice().equals(other.getSellingPrice()))
            && (this.getStockNum() == null ? other.getStockNum() == null : this.getStockNum().equals(other.getStockNum()))
            && (this.getTag() == null ? other.getTag() == null : this.getTag().equals(other.getTag()))
            && (this.getGoodsSellStatus() == null ? other.getGoodsSellStatus() == null : this.getGoodsSellStatus().equals(other.getGoodsSellStatus()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsIntro() == null) ? 0 : getGoodsIntro().hashCode());
        result = prime * result + ((getGoodsCategoryId() == null) ? 0 : getGoodsCategoryId().hashCode());
        result = prime * result + ((getGoodsCoverImg() == null) ? 0 : getGoodsCoverImg().hashCode());
        result = prime * result + ((getGoodsCarousel() == null) ? 0 : getGoodsCarousel().hashCode());
        result = prime * result + ((getGoodsDetailContent() == null) ? 0 : getGoodsDetailContent().hashCode());
        result = prime * result + ((getOriginalPrice() == null) ? 0 : getOriginalPrice().hashCode());
        result = prime * result + ((getSellingPrice() == null) ? 0 : getSellingPrice().hashCode());
        result = prime * result + ((getStockNum() == null) ? 0 : getStockNum().hashCode());
        result = prime * result + ((getTag() == null) ? 0 : getTag().hashCode());
        result = prime * result + ((getGoodsSellStatus() == null) ? 0 : getGoodsSellStatus().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsIntro=").append(goodsIntro);
        sb.append(", goodsCategoryId=").append(goodsCategoryId);
        sb.append(", goodsCoverImg=").append(goodsCoverImg);
        sb.append(", goodsCarousel=").append(goodsCarousel);
        sb.append(", goodsDetailContent=").append(goodsDetailContent);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", sellingPrice=").append(sellingPrice);
        sb.append(", stockNum=").append(stockNum);
        sb.append(", tag=").append(tag);
        sb.append(", goodsSellStatus=").append(goodsSellStatus);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}