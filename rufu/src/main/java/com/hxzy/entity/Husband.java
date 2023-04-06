package com.hxzy.entity;

import java.io.Serializable;

/**
 * 丈夫信息表
 * @TableName husband
 */
public class Husband implements Serializable {
    /**
     * 主键
     */
    private Long husbandId;

    /**
     * 身份证号码
     */
    private String numberId;

    /**
     * 名字
     */
    private String name;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 疾病史
     */
    private String illness;

    /**
     * 是否抽烟
     */
    private Integer smokingOtherId;

    /**
     * 妻子信息（外键）
     */
    private String elementaryId;

    /**
     * 血型
     */
    private Integer bloodOtherId;

    /**
     * 血型-\+
     */
    private Integer hrOtherId;

    /**
     * 吸烟量
     */
    private String smokingQuantity;

    /**
     * 是否饮酒
     */
    private Integer drinkOtherId;

    /**
     * 饮酒量
     */
    private String drinkQuantity;

    /**
     * 关系
     */
    private Integer relationOtherId;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Long getHusbandId() {
        return husbandId;
    }

    /**
     * 主键
     */
    public void setHusbandId(Long husbandId) {
        this.husbandId = husbandId;
    }

    /**
     * 身份证号码
     */
    public String getNumberId() {
        return numberId;
    }

    /**
     * 身份证号码
     */
    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    /**
     * 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 职业
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * 职业
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * 疾病史
     */
    public String getIllness() {
        return illness;
    }

    /**
     * 疾病史
     */
    public void setIllness(String illness) {
        this.illness = illness;
    }

    /**
     * 是否抽烟
     */
    public Integer getSmokingOtherId() {
        return smokingOtherId;
    }

    /**
     * 是否抽烟
     */
    public void setSmokingOtherId(Integer smokingOtherId) {
        this.smokingOtherId = smokingOtherId;
    }

    /**
     * 妻子信息（外键）
     */
    public String getElementaryId() {
        return elementaryId;
    }

    /**
     * 妻子信息（外键）
     */
    public void setElementaryId(String elementaryId) {
        this.elementaryId = elementaryId;
    }

    /**
     * 血型
     */
    public Integer getBloodOtherId() {
        return bloodOtherId;
    }

    /**
     * 血型
     */
    public void setBloodOtherId(Integer bloodOtherId) {
        this.bloodOtherId = bloodOtherId;
    }

    /**
     * 血型-\+
     */
    public Integer getHrOtherId() {
        return hrOtherId;
    }

    /**
     * 血型-\+
     */
    public void setHrOtherId(Integer hrOtherId) {
        this.hrOtherId = hrOtherId;
    }

    /**
     * 吸烟量
     */
    public String getSmokingQuantity() {
        return smokingQuantity;
    }

    /**
     * 吸烟量
     */
    public void setSmokingQuantity(String smokingQuantity) {
        this.smokingQuantity = smokingQuantity;
    }

    /**
     * 是否饮酒
     */
    public Integer getDrinkOtherId() {
        return drinkOtherId;
    }

    /**
     * 是否饮酒
     */
    public void setDrinkOtherId(Integer drinkOtherId) {
        this.drinkOtherId = drinkOtherId;
    }

    /**
     * 饮酒量
     */
    public String getDrinkQuantity() {
        return drinkQuantity;
    }

    /**
     * 饮酒量
     */
    public void setDrinkQuantity(String drinkQuantity) {
        this.drinkQuantity = drinkQuantity;
    }

    /**
     * 关系
     */
    public Integer getRelationOtherId() {
        return relationOtherId;
    }

    /**
     * 关系
     */
    public void setRelationOtherId(Integer relationOtherId) {
        this.relationOtherId = relationOtherId;
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
        Husband other = (Husband) that;
        return (this.getHusbandId() == null ? other.getHusbandId() == null : this.getHusbandId().equals(other.getHusbandId()))
            && (this.getNumberId() == null ? other.getNumberId() == null : this.getNumberId().equals(other.getNumberId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getOccupation() == null ? other.getOccupation() == null : this.getOccupation().equals(other.getOccupation()))
            && (this.getIllness() == null ? other.getIllness() == null : this.getIllness().equals(other.getIllness()))
            && (this.getSmokingOtherId() == null ? other.getSmokingOtherId() == null : this.getSmokingOtherId().equals(other.getSmokingOtherId()))
            && (this.getElementaryId() == null ? other.getElementaryId() == null : this.getElementaryId().equals(other.getElementaryId()))
            && (this.getBloodOtherId() == null ? other.getBloodOtherId() == null : this.getBloodOtherId().equals(other.getBloodOtherId()))
            && (this.getHrOtherId() == null ? other.getHrOtherId() == null : this.getHrOtherId().equals(other.getHrOtherId()))
            && (this.getSmokingQuantity() == null ? other.getSmokingQuantity() == null : this.getSmokingQuantity().equals(other.getSmokingQuantity()))
            && (this.getDrinkOtherId() == null ? other.getDrinkOtherId() == null : this.getDrinkOtherId().equals(other.getDrinkOtherId()))
            && (this.getDrinkQuantity() == null ? other.getDrinkQuantity() == null : this.getDrinkQuantity().equals(other.getDrinkQuantity()))
            && (this.getRelationOtherId() == null ? other.getRelationOtherId() == null : this.getRelationOtherId().equals(other.getRelationOtherId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHusbandId() == null) ? 0 : getHusbandId().hashCode());
        result = prime * result + ((getNumberId() == null) ? 0 : getNumberId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getOccupation() == null) ? 0 : getOccupation().hashCode());
        result = prime * result + ((getIllness() == null) ? 0 : getIllness().hashCode());
        result = prime * result + ((getSmokingOtherId() == null) ? 0 : getSmokingOtherId().hashCode());
        result = prime * result + ((getElementaryId() == null) ? 0 : getElementaryId().hashCode());
        result = prime * result + ((getBloodOtherId() == null) ? 0 : getBloodOtherId().hashCode());
        result = prime * result + ((getHrOtherId() == null) ? 0 : getHrOtherId().hashCode());
        result = prime * result + ((getSmokingQuantity() == null) ? 0 : getSmokingQuantity().hashCode());
        result = prime * result + ((getDrinkOtherId() == null) ? 0 : getDrinkOtherId().hashCode());
        result = prime * result + ((getDrinkQuantity() == null) ? 0 : getDrinkQuantity().hashCode());
        result = prime * result + ((getRelationOtherId() == null) ? 0 : getRelationOtherId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", husbandId=").append(husbandId);
        sb.append(", numberId=").append(numberId);
        sb.append(", name=").append(name);
        sb.append(", occupation=").append(occupation);
        sb.append(", illness=").append(illness);
        sb.append(", smokingOtherId=").append(smokingOtherId);
        sb.append(", elementaryId=").append(elementaryId);
        sb.append(", bloodOtherId=").append(bloodOtherId);
        sb.append(", hrOtherId=").append(hrOtherId);
        sb.append(", smokingQuantity=").append(smokingQuantity);
        sb.append(", drinkOtherId=").append(drinkOtherId);
        sb.append(", drinkQuantity=").append(drinkQuantity);
        sb.append(", relationOtherId=").append(relationOtherId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}