package com.hxzy.entity;

import java.io.Serializable;

/**
 * 
 * @TableName hxzy_exam_admin_user
 */
public class HxzyExamAdminUser implements Serializable {
    /**
     * 管理员id
     */
    private Long adminUserId;

    /**
     * 管理员登陆名称
     */
    private String loginUserName;

    /**
     * md5加密后的管理员登陆密码
     */
    private String loginPassword;

    /**
     * 管理员显示昵称
     */
    private String nickName;

    /**
     * 是否锁定 0未锁定 1已锁定无法登陆
     */
    private Integer locked;

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    public Long getAdminUserId() {
        return adminUserId;
    }

    /**
     * 管理员id
     */
    public void setAdminUserId(Long adminUserId) {
        this.adminUserId = adminUserId;
    }

    /**
     * 管理员登陆名称
     */
    public String getLoginUserName() {
        return loginUserName;
    }

    /**
     * 管理员登陆名称
     */
    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    /**
     * md5加密后的管理员登陆密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * md5加密后的管理员登陆密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * 管理员显示昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 管理员显示昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 是否锁定 0未锁定 1已锁定无法登陆
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * 是否锁定 0未锁定 1已锁定无法登陆
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
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
        HxzyExamAdminUser other = (HxzyExamAdminUser) that;
        return (this.getAdminUserId() == null ? other.getAdminUserId() == null : this.getAdminUserId().equals(other.getAdminUserId()))
            && (this.getLoginUserName() == null ? other.getLoginUserName() == null : this.getLoginUserName().equals(other.getLoginUserName()))
            && (this.getLoginPassword() == null ? other.getLoginPassword() == null : this.getLoginPassword().equals(other.getLoginPassword()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getLocked() == null ? other.getLocked() == null : this.getLocked().equals(other.getLocked()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminUserId() == null) ? 0 : getAdminUserId().hashCode());
        result = prime * result + ((getLoginUserName() == null) ? 0 : getLoginUserName().hashCode());
        result = prime * result + ((getLoginPassword() == null) ? 0 : getLoginPassword().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getLocked() == null) ? 0 : getLocked().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminUserId=").append(adminUserId);
        sb.append(", loginUserName=").append(loginUserName);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", nickName=").append(nickName);
        sb.append(", locked=").append(locked);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}