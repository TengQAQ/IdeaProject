package com.ming.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName employee
 */
public class Employee implements Serializable {
    /**
     * 员工id，主键，自增长
     */
    private Object id;

    /**
     * 员工登录名称
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 状态（正常--1、离职--0）
     */
    private Integer status;

    /**
     * 所属部门id
     */
    private Integer ofDepartment;

    /**
     * 
     */
    private Date entryTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 职位(负责人--0、普遍员工--1)
     */
    private Integer position;

    /**
     * 令牌
     */
    private String token;

    /**
     * 令牌失效时间
     */
    private Long expire;

    /**
     * 
     */
    private String avatar;

    private static final long serialVersionUID = 1L;

    /**
     * 员工id，主键，自增长
     */
    public Object getId() {
        return id;
    }

    /**
     * 员工id，主键，自增长
     */
    public void setId(Object id) {
        this.id = id;
    }

    /**
     * 员工登录名称
     */
    public String getUsername() {
        return username;
    }

    /**
     * 员工登录名称
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 员工姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 员工姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 状态（正常--1、离职--0）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态（正常--1、离职--0）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 所属部门id
     */
    public Integer getOfDepartment() {
        return ofDepartment;
    }

    /**
     * 所属部门id
     */
    public void setOfDepartment(Integer ofDepartment) {
        this.ofDepartment = ofDepartment;
    }

    /**
     * 
     */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
     * 
     */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 职位(负责人--0、普遍员工--1)
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * 职位(负责人--0、普遍员工--1)
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * 令牌
     */
    public String getToken() {
        return token;
    }

    /**
     * 令牌
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 令牌失效时间
     */
    public Long getExpire() {
        return expire;
    }

    /**
     * 令牌失效时间
     */
    public void setExpire(Long expire) {
        this.expire = expire;
    }

    /**
     * 
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
        Employee other = (Employee) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOfDepartment() == null ? other.getOfDepartment() == null : this.getOfDepartment().equals(other.getOfDepartment()))
            && (this.getEntryTime() == null ? other.getEntryTime() == null : this.getEntryTime().equals(other.getEntryTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getExpire() == null ? other.getExpire() == null : this.getExpire().equals(other.getExpire()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOfDepartment() == null) ? 0 : getOfDepartment().hashCode());
        result = prime * result + ((getEntryTime() == null) ? 0 : getEntryTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getExpire() == null) ? 0 : getExpire().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", ofDepartment=").append(ofDepartment);
        sb.append(", entryTime=").append(entryTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", position=").append(position);
        sb.append(", token=").append(token);
        sb.append(", expire=").append(expire);
        sb.append(", avatar=").append(avatar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}