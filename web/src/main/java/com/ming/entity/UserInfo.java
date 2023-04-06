package com.ming.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName user_info
 */
public class UserInfo implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 使用手机号作为用户账户
     */
    private String mobile;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 0:男  1:女
     */
    private Integer sex;

    /**
     * 注册时间
     */
    private Date regTime;

    /**
     * 最后登录平台时间
     */
    private Date lastLogin;

    /**
     * 用户积分
     */
    private Integer userPoint;

    /**
     * 
     */
    private Date receiveDate;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 微信openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 微信openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 使用手机号作为用户账户
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 使用手机号作为用户账户
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 0:男  1:女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 0:男  1:女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 注册时间
     */
    public Date getRegTime() {
        return regTime;
    }

    /**
     * 注册时间
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    /**
     * 最后登录平台时间
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * 最后登录平台时间
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * 用户积分
     */
    public Integer getUserPoint() {
        return userPoint;
    }

    /**
     * 用户积分
     */
    public void setUserPoint(Integer userPoint) {
        this.userPoint = userPoint;
    }

    /**
     * 
     */
    public Date getReceiveDate() {
        return receiveDate;
    }

    /**
     * 
     */
    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
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
        UserInfo other = (UserInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getRegTime() == null ? other.getRegTime() == null : this.getRegTime().equals(other.getRegTime()))
            && (this.getLastLogin() == null ? other.getLastLogin() == null : this.getLastLogin().equals(other.getLastLogin()))
            && (this.getUserPoint() == null ? other.getUserPoint() == null : this.getUserPoint().equals(other.getUserPoint()))
            && (this.getReceiveDate() == null ? other.getReceiveDate() == null : this.getReceiveDate().equals(other.getReceiveDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getRegTime() == null) ? 0 : getRegTime().hashCode());
        result = prime * result + ((getLastLogin() == null) ? 0 : getLastLogin().hashCode());
        result = prime * result + ((getUserPoint() == null) ? 0 : getUserPoint().hashCode());
        result = prime * result + ((getReceiveDate() == null) ? 0 : getReceiveDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openid=").append(openid);
        sb.append(", mobile=").append(mobile);
        sb.append(", nickname=").append(nickname);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", regTime=").append(regTime);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", userPoint=").append(userPoint);
        sb.append(", receiveDate=").append(receiveDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}