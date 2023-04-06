package com.hxzy.entity;

import java.io.Serializable;

/**
 * 孕妇表
 * @TableName elementary
 */
public class Elementary implements Serializable {
    /**
     * 主键
     */
    private String elementaryId;

    /**
     * 身份证号码
     */
    private String numberId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 民族
     */
    private String nation;

    /**
     * 籍贯
     */
    private String place;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 文化水平
     */
    private String culture;

    /**
     * 性别
     */
    private String gender;

    /**
     * 结婚年龄
     */
    private Integer marriageAge;

    /**
     * 孕前身高
     */
    private Double progestationHeight;

    /**
     * 孕前体重
     */
    private Double progestationWeight;

    /**
     * 孕后体重
     */
    private Double rearWeight;

    /**
     * 血型
     */
    private Integer bloodOtherId;

    /**
     * 孕前BMI
     */
    private Double progestationBmi;

    /**
     * 孕后BMI
     */
    private Double rearBmi;

    /**
     * 是否抽烟
     */
    private Integer smokingOtherId;

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
     * 血型-\+
     */
    private Integer hrOtherId;

    /**
     * 婚姻
     */
    private Integer marriageOtherId;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public String getElementaryId() {
        return elementaryId;
    }

    /**
     * 主键
     */
    public void setElementaryId(String elementaryId) {
        this.elementaryId = elementaryId;
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
     * 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 民族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 籍贯
     */
    public String getPlace() {
        return place;
    }

    /**
     * 籍贯
     */
    public void setPlace(String place) {
        this.place = place;
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
     * 文化水平
     */
    public String getCulture() {
        return culture;
    }

    /**
     * 文化水平
     */
    public void setCulture(String culture) {
        this.culture = culture;
    }

    /**
     * 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 结婚年龄
     */
    public Integer getMarriageAge() {
        return marriageAge;
    }

    /**
     * 结婚年龄
     */
    public void setMarriageAge(Integer marriageAge) {
        this.marriageAge = marriageAge;
    }

    /**
     * 孕前身高
     */
    public Double getProgestationHeight() {
        return progestationHeight;
    }

    /**
     * 孕前身高
     */
    public void setProgestationHeight(Double progestationHeight) {
        this.progestationHeight = progestationHeight;
    }

    /**
     * 孕前体重
     */
    public Double getProgestationWeight() {
        return progestationWeight;
    }

    /**
     * 孕前体重
     */
    public void setProgestationWeight(Double progestationWeight) {
        this.progestationWeight = progestationWeight;
    }

    /**
     * 孕后体重
     */
    public Double getRearWeight() {
        return rearWeight;
    }

    /**
     * 孕后体重
     */
    public void setRearWeight(Double rearWeight) {
        this.rearWeight = rearWeight;
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
     * 孕前BMI
     */
    public Double getProgestationBmi() {
        return progestationBmi;
    }

    /**
     * 孕前BMI
     */
    public void setProgestationBmi(Double progestationBmi) {
        this.progestationBmi = progestationBmi;
    }

    /**
     * 孕后BMI
     */
    public Double getRearBmi() {
        return rearBmi;
    }

    /**
     * 孕后BMI
     */
    public void setRearBmi(Double rearBmi) {
        this.rearBmi = rearBmi;
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
     * 婚姻
     */
    public Integer getMarriageOtherId() {
        return marriageOtherId;
    }

    /**
     * 婚姻
     */
    public void setMarriageOtherId(Integer marriageOtherId) {
        this.marriageOtherId = marriageOtherId;
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
        Elementary other = (Elementary) that;
        return (this.getElementaryId() == null ? other.getElementaryId() == null : this.getElementaryId().equals(other.getElementaryId()))
            && (this.getNumberId() == null ? other.getNumberId() == null : this.getNumberId().equals(other.getNumberId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getPlace() == null ? other.getPlace() == null : this.getPlace().equals(other.getPlace()))
            && (this.getOccupation() == null ? other.getOccupation() == null : this.getOccupation().equals(other.getOccupation()))
            && (this.getCulture() == null ? other.getCulture() == null : this.getCulture().equals(other.getCulture()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getMarriageAge() == null ? other.getMarriageAge() == null : this.getMarriageAge().equals(other.getMarriageAge()))
            && (this.getProgestationHeight() == null ? other.getProgestationHeight() == null : this.getProgestationHeight().equals(other.getProgestationHeight()))
            && (this.getProgestationWeight() == null ? other.getProgestationWeight() == null : this.getProgestationWeight().equals(other.getProgestationWeight()))
            && (this.getRearWeight() == null ? other.getRearWeight() == null : this.getRearWeight().equals(other.getRearWeight()))
            && (this.getBloodOtherId() == null ? other.getBloodOtherId() == null : this.getBloodOtherId().equals(other.getBloodOtherId()))
            && (this.getProgestationBmi() == null ? other.getProgestationBmi() == null : this.getProgestationBmi().equals(other.getProgestationBmi()))
            && (this.getRearBmi() == null ? other.getRearBmi() == null : this.getRearBmi().equals(other.getRearBmi()))
            && (this.getSmokingOtherId() == null ? other.getSmokingOtherId() == null : this.getSmokingOtherId().equals(other.getSmokingOtherId()))
            && (this.getSmokingQuantity() == null ? other.getSmokingQuantity() == null : this.getSmokingQuantity().equals(other.getSmokingQuantity()))
            && (this.getDrinkOtherId() == null ? other.getDrinkOtherId() == null : this.getDrinkOtherId().equals(other.getDrinkOtherId()))
            && (this.getDrinkQuantity() == null ? other.getDrinkQuantity() == null : this.getDrinkQuantity().equals(other.getDrinkQuantity()))
            && (this.getHrOtherId() == null ? other.getHrOtherId() == null : this.getHrOtherId().equals(other.getHrOtherId()))
            && (this.getMarriageOtherId() == null ? other.getMarriageOtherId() == null : this.getMarriageOtherId().equals(other.getMarriageOtherId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getElementaryId() == null) ? 0 : getElementaryId().hashCode());
        result = prime * result + ((getNumberId() == null) ? 0 : getNumberId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getPlace() == null) ? 0 : getPlace().hashCode());
        result = prime * result + ((getOccupation() == null) ? 0 : getOccupation().hashCode());
        result = prime * result + ((getCulture() == null) ? 0 : getCulture().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getMarriageAge() == null) ? 0 : getMarriageAge().hashCode());
        result = prime * result + ((getProgestationHeight() == null) ? 0 : getProgestationHeight().hashCode());
        result = prime * result + ((getProgestationWeight() == null) ? 0 : getProgestationWeight().hashCode());
        result = prime * result + ((getRearWeight() == null) ? 0 : getRearWeight().hashCode());
        result = prime * result + ((getBloodOtherId() == null) ? 0 : getBloodOtherId().hashCode());
        result = prime * result + ((getProgestationBmi() == null) ? 0 : getProgestationBmi().hashCode());
        result = prime * result + ((getRearBmi() == null) ? 0 : getRearBmi().hashCode());
        result = prime * result + ((getSmokingOtherId() == null) ? 0 : getSmokingOtherId().hashCode());
        result = prime * result + ((getSmokingQuantity() == null) ? 0 : getSmokingQuantity().hashCode());
        result = prime * result + ((getDrinkOtherId() == null) ? 0 : getDrinkOtherId().hashCode());
        result = prime * result + ((getDrinkQuantity() == null) ? 0 : getDrinkQuantity().hashCode());
        result = prime * result + ((getHrOtherId() == null) ? 0 : getHrOtherId().hashCode());
        result = prime * result + ((getMarriageOtherId() == null) ? 0 : getMarriageOtherId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", elementaryId=").append(elementaryId);
        sb.append(", numberId=").append(numberId);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", nation=").append(nation);
        sb.append(", place=").append(place);
        sb.append(", occupation=").append(occupation);
        sb.append(", culture=").append(culture);
        sb.append(", gender=").append(gender);
        sb.append(", marriageAge=").append(marriageAge);
        sb.append(", progestationHeight=").append(progestationHeight);
        sb.append(", progestationWeight=").append(progestationWeight);
        sb.append(", rearWeight=").append(rearWeight);
        sb.append(", bloodOtherId=").append(bloodOtherId);
        sb.append(", progestationBmi=").append(progestationBmi);
        sb.append(", rearBmi=").append(rearBmi);
        sb.append(", smokingOtherId=").append(smokingOtherId);
        sb.append(", smokingQuantity=").append(smokingQuantity);
        sb.append(", drinkOtherId=").append(drinkOtherId);
        sb.append(", drinkQuantity=").append(drinkQuantity);
        sb.append(", hrOtherId=").append(hrOtherId);
        sb.append(", marriageOtherId=").append(marriageOtherId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}