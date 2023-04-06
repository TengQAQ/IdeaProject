package com.ming.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName hxzy_exam_admin_user_token
 */
public class HxzyExamAdminUserToken implements Serializable {
    /**
     * 用户主键id
     */
    private Long adminUserId;

    /**
     * token值(32位字符串)
     */
    private String token;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * token过期时间
     */
    private Date expireTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键id
     */
    public Long getAdminUserId() {
        return adminUserId;
    }

    /**
     * 用户主键id
     */
    public void setAdminUserId(Long adminUserId) {
        this.adminUserId = adminUserId;
    }

    /**
     * token值(32位字符串)
     */
    public String getToken() {
        return token;
    }

    /**
     * token值(32位字符串)
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * token过期时间
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * token过期时间
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HxzyExamAdminUserToken)) return false;

        HxzyExamAdminUserToken that = (HxzyExamAdminUserToken) o;

        return getAdminUserId() != null ? getAdminUserId().equals(that.getAdminUserId()) : that.getAdminUserId() == null;
    }

    @Override
    public int hashCode() {
        return getAdminUserId() != null ? getAdminUserId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "HxzyExamAdminUserToken{" +
                "adminUserId=" + adminUserId +
                ", token='" + token + '\'' +
                ", updateTime=" + updateTime +
                ", expireTime=" + expireTime +
                ", userName='" + userName + '\'' +
                '}';
    }
}