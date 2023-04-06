package com.hxzy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员表
 * @TableName role
 */
public class Role implements Serializable {
    /**
     * 主键自增长
     */
    private Integer roleId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 账号
     */
    private String number;

    /**
     * 密码(默认为'a12345678')
     */
    private String password;

    /**
     * 创建地址
     */
    private String location;

    /**
     * 创建时间
     */
    private Date time;

    /**
     * 电话
     */
    private Long phone;

    /**
     * 状态
     */
    private Integer stateId;

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增长
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 主键自增长
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
     * 账号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 账号
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 密码(默认为'a12345678')
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码(默认为'a12345678')
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 创建地址
     */
    public String getLocation() {
        return location;
    }

    /**
     * 创建地址
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 创建时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 创建时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 电话
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * 电话
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     * 状态
     */
    public Integer getStateId() {
        return stateId;
    }

    /**
     * 状态
     */
    public void setStateId(Integer stateId) {
        this.stateId = stateId;
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
        Role other = (Role) that;
        return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getStateId() == null ? other.getStateId() == null : this.getStateId().equals(other.getStateId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getStateId() == null) ? 0 : getStateId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", name=").append(name);
        sb.append(", number=").append(number);
        sb.append(", password=").append(password);
        sb.append(", location=").append(location);
        sb.append(", time=").append(time);
        sb.append(", phone=").append(phone);
        sb.append(", stateId=").append(stateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}