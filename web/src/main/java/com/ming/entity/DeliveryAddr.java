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
     * rw_user_info主键
     */
    private UserInfo userInfo;

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
     * 收货地址（省，直辖市）（rw_addr_info的id）
     */
    private Integer addrFirst;

    /**
     * 收货地址（市级，直辖区）（rw_addr_info的id）
     */
    private Integer addrSecond;

    /**
     * 收货地址（镇/区，街道）（rw_addr_info的id）
     */
    private Integer addrThird;

    /**
     * 送货时间
     */
    private Integer bestTime;

    /**
     * 是否默认收货地址，0非默认，1默认
     */
    private String isDefault;

    /**
     * 预留字段
     */
    private String value2;

    /**
     * 预留字段
     */
    private String value3;

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
     * rw_user_info主键
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
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
     * 收货地址（省，直辖市）（rw_addr_info的id）
     */
    public Integer getAddrFirst() {
        return addrFirst;
    }

    /**
     * 收货地址（省，直辖市）（rw_addr_info的id）
     */
    public void setAddrFirst(Integer addrFirst) {
        this.addrFirst = addrFirst;
    }

    /**
     * 收货地址（市级，直辖区）（rw_addr_info的id）
     */
    public Integer getAddrSecond() {
        return addrSecond;
    }

    /**
     * 收货地址（市级，直辖区）（rw_addr_info的id）
     */
    public void setAddrSecond(Integer addrSecond) {
        this.addrSecond = addrSecond;
    }

    /**
     * 收货地址（镇/区，街道）（rw_addr_info的id）
     */
    public Integer getAddrThird() {
        return addrThird;
    }

    /**
     * 收货地址（镇/区，街道）（rw_addr_info的id）
     */
    public void setAddrThird(Integer addrThird) {
        this.addrThird = addrThird;
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
     * 预留字段
     */
    public String getValue2() {
        return value2;
    }

    /**
     * 预留字段
     */
    public void setValue2(String value2) {
        this.value2 = value2;
    }

    /**
     * 预留字段
     */
    public String getValue3() {
        return value3;
    }

    /**
     * 预留字段
     */
    public void setValue3(String value3) {
        this.value3 = value3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeliveryAddr)) return false;

        DeliveryAddr that = (DeliveryAddr) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DeliveryAddr{" +
                "id=" + id +
                ", userId=" + userInfo +
                ", contactsName='" + contactsName + '\'' +
                ", contactsTel='" + contactsTel + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", addr='" + addr + '\'' +
                ", addrFirst=" + addrFirst +
                ", addrSecond=" + addrSecond +
                ", addrThird=" + addrThird +
                ", bestTime=" + bestTime +
                ", isDefault='" + isDefault + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                '}';
    }
}