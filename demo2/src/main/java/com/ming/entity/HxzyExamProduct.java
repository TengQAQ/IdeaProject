package com.ming.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName hxzy_exam_product
 */
public class HxzyExamProduct implements Serializable {
    /**
     * 商品编号，由java生成，格式HK+yyyyMMdd+4位不重复的数
     */
    private String id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 销售模式
     */
    private String standard;

    /**
     * 单位
     */
    private String unit;

    /**
     * 三级分类编号
     */
    private String categoryId;

    /**
     * 卖点
     */
    private String intro;

    /**
     * 采购价格
     */
    private BigDecimal buyPrice;

    /**
     * 销售价格
     */
    private BigDecimal salePrice;

    /**
     * 是否被删除，默认为0
     */
    private Integer isDel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后一次修改时间
     */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    /**
     * 商品编号，由java生成，格式HK+yyyyMMdd+4位不重复的数
     */
    public String getId() {
        return id;
    }

    /**
     * 商品编号，由java生成，格式HK+yyyyMMdd+4位不重复的数
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 销售模式
     */
    public String getStandard() {
        return standard;
    }

    /**
     * 销售模式
     */
    public void setStandard(String standard) {
        this.standard = standard;
    }

    /**
     * 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 三级分类编号
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 三级分类编号
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 卖点
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 卖点
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * 采购价格
     */
    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    /**
     * 采购价格
     */
    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * 销售价格
     */
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    /**
     * 销售价格
     */
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * 是否被删除，默认为0
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 是否被删除，默认为0
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后一次修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后一次修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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
        HxzyExamProduct other = (HxzyExamProduct) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStandard() == null ? other.getStandard() == null : this.getStandard().equals(other.getStandard()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getIntro() == null ? other.getIntro() == null : this.getIntro().equals(other.getIntro()))
            && (this.getBuyPrice() == null ? other.getBuyPrice() == null : this.getBuyPrice().equals(other.getBuyPrice()))
            && (this.getSalePrice() == null ? other.getSalePrice() == null : this.getSalePrice().equals(other.getSalePrice()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStandard() == null) ? 0 : getStandard().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getIntro() == null) ? 0 : getIntro().hashCode());
        result = prime * result + ((getBuyPrice() == null) ? 0 : getBuyPrice().hashCode());
        result = prime * result + ((getSalePrice() == null) ? 0 : getSalePrice().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", standard=").append(standard);
        sb.append(", unit=").append(unit);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", intro=").append(intro);
        sb.append(", buyPrice=").append(buyPrice);
        sb.append(", salePrice=").append(salePrice);
        sb.append(", isDel=").append(isDel);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}