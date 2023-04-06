package com.ming.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录令牌表
 * @TableName hr_token
 */
public class HrToken implements Serializable {
    /**
     * 管理员主键id
     */
    private Long hrId;

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

    private static final long serialVersionUID = 1L;

    /**
     * 管理员主键id
     */
    public Long getHrId() {
        return hrId;
    }

    /**
     * 管理员主键id
     */
    public void setHrId(Long hrId) {
        this.hrId = hrId;
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
        HrToken other = (HrToken) that;
        return (this.getHrId() == null ? other.getHrId() == null : this.getHrId().equals(other.getHrId()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getExpireTime() == null ? other.getExpireTime() == null : this.getExpireTime().equals(other.getExpireTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHrId() == null) ? 0 : getHrId().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getExpireTime() == null) ? 0 : getExpireTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hrId=").append(hrId);
        sb.append(", token=").append(token);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}