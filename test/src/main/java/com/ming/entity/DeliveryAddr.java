package com.ming.entity;

import java.io.Serializable;

/**
 * 
 * @TableName delivery_addr
 */
public class DeliveryAddr implements Serializable {
    /**
     * 主键，自增长
     */
    private Integer id;

    /**
     * user_info主键
     */
    private Integer userId;

    /**
     * 收货联系人名称
     */
    private String contactsName;

    /**
     * 收货联系电话
     */
    private String contactsTel;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 自定义收货地址
     */
    private String addr;

    /**
     * 送货时间
     */
    private Integer bestTime;

    /**
     * 是否默认收货地址，0非默认，1默认
     */
    private String isDefault;

    /**
     * 省市，addr_info中lev为1的主键
     */
    private Integer firstAddr;

    /**
     * 区县，addr_info中lev为2的主键
     */
    private Integer secondAddr;

    /**
     * 乡镇，addr_info中lev为3的主键
     */
    private Integer thridAddr;

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增长
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键，自增长
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * user_info主键
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * user_info主键
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 收货联系人名称
     */
    public String getContactsName() {
        return contactsName;
    }

    /**
     * 收货联系人名称
     */
    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    /**
     * 收货联系电话
     */
    public String getContactsTel() {
        return contactsTel;
    }

    /**
     * 收货联系电话
     */
    public void setContactsTel(String contactsTel) {
        this.contactsTel = contactsTel;
    }

    /**
     * 邮编
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 自定义收货地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 自定义收货地址
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 送货时间
     */
    public Integer getBestTime() {
        return bestTime;
    }

    /**
     * 送货时间
     */
    public void setBestTime(Integer bestTime) {
        this.bestTime = bestTime;
    }

    /**
     * 是否默认收货地址，0非默认，1默认
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * 是否默认收货地址，0非默认，1默认
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 省市，addr_info中lev为1的主键
     */
    public Integer getFirstAddr() {
        return firstAddr;
    }

    /**
     * 省市，addr_info中lev为1的主键
     */
    public void setFirstAddr(Integer firstAddr) {
        this.firstAddr = firstAddr;
    }

    /**
     * 区县，addr_info中lev为2的主键
     */
    public Integer getSecondAddr() {
        return secondAddr;
    }

    /**
     * 区县，addr_info中lev为2的主键
     */
    public void setSecondAddr(Integer secondAddr) {
        this.secondAddr = secondAddr;
    }

    /**
     * 乡镇，addr_info中lev为3的主键
     */
    public Integer getThridAddr() {
        return thridAddr;
    }

    /**
     * 乡镇，addr_info中lev为3的主键
     */
    public void setThridAddr(Integer thridAddr) {
        this.thridAddr = thridAddr;
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
        DeliveryAddr other = (DeliveryAddr) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getContactsName() == null ? other.getContactsName() == null : this.getContactsName().equals(other.getContactsName()))
            && (this.getContactsTel() == null ? other.getContactsTel() == null : this.getContactsTel().equals(other.getContactsTel()))
            && (this.getZipCode() == null ? other.getZipCode() == null : this.getZipCode().equals(other.getZipCode()))
            && (this.getAddr() == null ? other.getAddr() == null : this.getAddr().equals(other.getAddr()))
            && (this.getBestTime() == null ? other.getBestTime() == null : this.getBestTime().equals(other.getBestTime()))
            && (this.getIsDefault() == null ? other.getIsDefault() == null : this.getIsDefault().equals(other.getIsDefault()))
            && (this.getFirstAddr() == null ? other.getFirstAddr() == null : this.getFirstAddr().equals(other.getFirstAddr()))
            && (this.getSecondAddr() == null ? other.getSecondAddr() == null : this.getSecondAddr().equals(other.getSecondAddr()))
            && (this.getThridAddr() == null ? other.getThridAddr() == null : this.getThridAddr().equals(other.getThridAddr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getContactsName() == null) ? 0 : getContactsName().hashCode());
        result = prime * result + ((getContactsTel() == null) ? 0 : getContactsTel().hashCode());
        result = prime * result + ((getZipCode() == null) ? 0 : getZipCode().hashCode());
        result = prime * result + ((getAddr() == null) ? 0 : getAddr().hashCode());
        result = prime * result + ((getBestTime() == null) ? 0 : getBestTime().hashCode());
        result = prime * result + ((getIsDefault() == null) ? 0 : getIsDefault().hashCode());
        result = prime * result + ((getFirstAddr() == null) ? 0 : getFirstAddr().hashCode());
        result = prime * result + ((getSecondAddr() == null) ? 0 : getSecondAddr().hashCode());
        result = prime * result + ((getThridAddr() == null) ? 0 : getThridAddr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", contactsName=").append(contactsName);
        sb.append(", contactsTel=").append(contactsTel);
        sb.append(", zipCode=").append(zipCode);
        sb.append(", addr=").append(addr);
        sb.append(", bestTime=").append(bestTime);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", firstAddr=").append(firstAddr);
        sb.append(", secondAddr=").append(secondAddr);
        sb.append(", thridAddr=").append(thridAddr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}