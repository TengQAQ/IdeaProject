package com.hxzy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName userlogin
 */
public class UserLogin implements Serializable {
    /**
     * 主键
     */
    private Object id;

    /**
     * 令牌
     */
    private String token;

    /**
     * 令牌失效时间
     */
    private Long expire;

    /**
     * 关联的用户
     */
    private String roleNumber;

    /**
     * 最后一次登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后一次登录的 ip地址
     */
    private String lastLoginIp;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Object getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Object id) {
        this.id = id;
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
     * 关联的用户
     */
    public String getRoleNumber() {
        return roleNumber;
    }

    /**
     * 关联的用户
     */
    public void setRoleNumber(String roleNumber) {
        this.roleNumber = roleNumber;
    }

    /**
     * 最后一次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后一次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 最后一次登录的 ip地址
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 最后一次登录的 ip地址
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserLogin)) return false;

        UserLogin userLogin = (UserLogin) o;

        return getId() != null ? getId().equals(userLogin.getId()) : userLogin.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", token=").append(token);
        sb.append(", expire=").append(expire);
        sb.append(", roleNumber=").append(roleNumber);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", lastLoginIp=").append(lastLoginIp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}