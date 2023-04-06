package com.xuefeng.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName goods_info
 */
public class GoodsInfo implements Serializable {
    /**
     * 商品编号
     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品货号
     */
    private String goodsSerial;

    /**
     * 商品图片
     */
    private String goodsImg;

    /**
     * 商品排序值
     */
    private Integer goodsSort;

    /**
     * 所属一级分类（rw_goods_type）
     */
    private Integer typeParentId;

    /**
     * 所属二级分类（rw_goods_type）
     */
    private Integer typeMiddleId;

    /**
     * 所属三级分类（rw_goods_type）
     */
    private Integer typeSubId;

    /**
     * 商品库存
     */
    private Integer storeNumber;

    /**
     * 商品已售
     */
    private Integer selledNumber;

    /**
     * 报警数量
     */
    private Integer warnNumber;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 商店售价
     */
    private BigDecimal shopPrice;

    /**
     * 默认1上架。 0下架
     */
    private Integer goodsEnable;

    /**
     * 商品详情
     */
    private String summary;

    /**
     * 1代表新品
     */
    private Integer isnew;

    /**
     * 1代表热卖
     */
    private Integer ishot;

    /**
     * 1代表首页推荐
     */
    private Integer isrecommand;

    private static final long serialVersionUID = 1L;

    /**
     * 商品编号
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 商品编号
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 商品货号
     */
    public String getGoodsSerial() {
        return goodsSerial;
    }

    /**
     * 商品货号
     */
    public void setGoodsSerial(String goodsSerial) {
        this.goodsSerial = goodsSerial;
    }

    /**
     * 商品图片
     */
    public String getGoodsImg() {
        return goodsImg;
    }

    /**
     * 商品图片
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    /**
     * 商品排序值
     */
    public Integer getGoodsSort() {
        return goodsSort;
    }

    /**
     * 商品排序值
     */
    public void setGoodsSort(Integer goodsSort) {
        this.goodsSort = goodsSort;
    }

    /**
     * 所属一级分类（rw_goods_type）
     */
    public Integer getTypeParentId() {
        return typeParentId;
    }

    /**
     * 所属一级分类（rw_goods_type）
     */
    public void setTypeParentId(Integer typeParentId) {
        this.typeParentId = typeParentId;
    }

    /**
     * 所属二级分类（rw_goods_type）
     */
    public Integer getTypeMiddleId() {
        return typeMiddleId;
    }

    /**
     * 所属二级分类（rw_goods_type）
     */
    public void setTypeMiddleId(Integer typeMiddleId) {
        this.typeMiddleId = typeMiddleId;
    }

    /**
     * 所属三级分类（rw_goods_type）
     */
    public Integer getTypeSubId() {
        return typeSubId;
    }

    /**
     * 所属三级分类（rw_goods_type）
     */
    public void setTypeSubId(Integer typeSubId) {
        this.typeSubId = typeSubId;
    }

    /**
     * 商品库存
     */
    public Integer getStoreNumber() {
        return storeNumber;
    }

    /**
     * 商品库存
     */
    public void setStoreNumber(Integer storeNumber) {
        this.storeNumber = storeNumber;
    }

    /**
     * 商品已售
     */
    public Integer getSelledNumber() {
        return selledNumber;
    }

    /**
     * 商品已售
     */
    public void setSelledNumber(Integer selledNumber) {
        this.selledNumber = selledNumber;
    }

    /**
     * 报警数量
     */
    public Integer getWarnNumber() {
        return warnNumber;
    }

    /**
     * 报警数量
     */
    public void setWarnNumber(Integer warnNumber) {
        this.warnNumber = warnNumber;
    }

    /**
     * 市场价
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * 市场价
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 商店售价
     */
    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    /**
     * 商店售价
     */
    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    /**
     * 默认1上架。 0下架
     */
    public Integer getGoodsEnable() {
        return goodsEnable;
    }

    /**
     * 默认1上架。 0下架
     */
    public void setGoodsEnable(Integer goodsEnable) {
        this.goodsEnable = goodsEnable;
    }

    /**
     * 商品详情
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 商品详情
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 1代表新品
     */
    public Integer getIsnew() {
        return isnew;
    }

    /**
     * 1代表新品
     */
    public void setIsnew(Integer isnew) {
        this.isnew = isnew;
    }

    /**
     * 1代表热卖
     */
    public Integer getIshot() {
        return ishot;
    }

    /**
     * 1代表热卖
     */
    public void setIshot(Integer ishot) {
        this.ishot = ishot;
    }

    /**
     * 1代表首页推荐
     */
    public Integer getIsrecommand() {
        return isrecommand;
    }

    /**
     * 1代表首页推荐
     */
    public void setIsrecommand(Integer isrecommand) {
        this.isrecommand = isrecommand;
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
        GoodsInfo other = (GoodsInfo) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsSerial() == null ? other.getGoodsSerial() == null : this.getGoodsSerial().equals(other.getGoodsSerial()))
            && (this.getGoodsImg() == null ? other.getGoodsImg() == null : this.getGoodsImg().equals(other.getGoodsImg()))
            && (this.getGoodsSort() == null ? other.getGoodsSort() == null : this.getGoodsSort().equals(other.getGoodsSort()))
            && (this.getTypeParentId() == null ? other.getTypeParentId() == null : this.getTypeParentId().equals(other.getTypeParentId()))
            && (this.getTypeMiddleId() == null ? other.getTypeMiddleId() == null : this.getTypeMiddleId().equals(other.getTypeMiddleId()))
            && (this.getTypeSubId() == null ? other.getTypeSubId() == null : this.getTypeSubId().equals(other.getTypeSubId()))
            && (this.getStoreNumber() == null ? other.getStoreNumber() == null : this.getStoreNumber().equals(other.getStoreNumber()))
            && (this.getSelledNumber() == null ? other.getSelledNumber() == null : this.getSelledNumber().equals(other.getSelledNumber()))
            && (this.getWarnNumber() == null ? other.getWarnNumber() == null : this.getWarnNumber().equals(other.getWarnNumber()))
            && (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
            && (this.getShopPrice() == null ? other.getShopPrice() == null : this.getShopPrice().equals(other.getShopPrice()))
            && (this.getGoodsEnable() == null ? other.getGoodsEnable() == null : this.getGoodsEnable().equals(other.getGoodsEnable()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getIsnew() == null ? other.getIsnew() == null : this.getIsnew().equals(other.getIsnew()))
            && (this.getIshot() == null ? other.getIshot() == null : this.getIshot().equals(other.getIshot()))
            && (this.getIsrecommand() == null ? other.getIsrecommand() == null : this.getIsrecommand().equals(other.getIsrecommand()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsSerial() == null) ? 0 : getGoodsSerial().hashCode());
        result = prime * result + ((getGoodsImg() == null) ? 0 : getGoodsImg().hashCode());
        result = prime * result + ((getGoodsSort() == null) ? 0 : getGoodsSort().hashCode());
        result = prime * result + ((getTypeParentId() == null) ? 0 : getTypeParentId().hashCode());
        result = prime * result + ((getTypeMiddleId() == null) ? 0 : getTypeMiddleId().hashCode());
        result = prime * result + ((getTypeSubId() == null) ? 0 : getTypeSubId().hashCode());
        result = prime * result + ((getStoreNumber() == null) ? 0 : getStoreNumber().hashCode());
        result = prime * result + ((getSelledNumber() == null) ? 0 : getSelledNumber().hashCode());
        result = prime * result + ((getWarnNumber() == null) ? 0 : getWarnNumber().hashCode());
        result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
        result = prime * result + ((getShopPrice() == null) ? 0 : getShopPrice().hashCode());
        result = prime * result + ((getGoodsEnable() == null) ? 0 : getGoodsEnable().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getIsnew() == null) ? 0 : getIsnew().hashCode());
        result = prime * result + ((getIshot() == null) ? 0 : getIshot().hashCode());
        result = prime * result + ((getIsrecommand() == null) ? 0 : getIsrecommand().hashCode());
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
        sb.append(", goodsSerial=").append(goodsSerial);
        sb.append(", goodsImg=").append(goodsImg);
        sb.append(", goodsSort=").append(goodsSort);
        sb.append(", typeParentId=").append(typeParentId);
        sb.append(", typeMiddleId=").append(typeMiddleId);
        sb.append(", typeSubId=").append(typeSubId);
        sb.append(", storeNumber=").append(storeNumber);
        sb.append(", selledNumber=").append(selledNumber);
        sb.append(", warnNumber=").append(warnNumber);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", shopPrice=").append(shopPrice);
        sb.append(", goodsEnable=").append(goodsEnable);
        sb.append(", summary=").append(summary);
        sb.append(", isnew=").append(isnew);
        sb.append(", ishot=").append(ishot);
        sb.append(", isrecommand=").append(isrecommand);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}