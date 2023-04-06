package com.ming.entity;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsInfo)) return false;

        GoodsInfo goodsInfo = (GoodsInfo) o;

        return getGoodsId() != null ? getGoodsId().equals(goodsInfo.getGoodsId()) : goodsInfo.getGoodsId() == null;
    }

    @Override
    public int hashCode() {
        return getGoodsId() != null ? getGoodsId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsSerial='" + goodsSerial + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsSort=" + goodsSort +
                ", typeParentId=" + typeParentId +
                ", typeMiddleId=" + typeMiddleId +
                ", typeSubId=" + typeSubId +
                ", storeNumber=" + storeNumber +
                ", selledNumber=" + selledNumber +
                ", warnNumber=" + warnNumber +
                ", marketPrice=" + marketPrice +
                ", shopPrice=" + shopPrice +
                ", goodsEnable=" + goodsEnable +
                ", summary='" + summary + '\'' +
                ", isnew=" + isnew +
                ", ishot=" + ishot +
                ", isrecommand=" + isrecommand +
                '}';
    }
}