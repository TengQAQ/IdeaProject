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
     * 使用手机号作为用户账户
     */
    private String mobile;

    /**
     * 登录密码
     */
    private String loginPassword;

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
     * 登录令牌
     */
    private String token;

    /**
     * 令牌失效时间
     */
    private Date expire;

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
     * 登录密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 登录密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
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
     * 登录令牌
     */
    public String getToken() {
        return token;
    }

    /**
     * 登录令牌
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 令牌失效时间
     */
    public Date getExpire() {
        return expire;
    }

    /**
     * 令牌失效时间
     */
    public void setExpire(Date expire) {
        this.expire = expire;
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
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getLoginPassword() == null ? other.getLoginPassword() == null : this.getLoginPassword().equals(other.getLoginPassword()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getRegTime() == null ? other.getRegTime() == null : this.getRegTime().equals(other.getRegTime()))
            && (this.getLastLogin() == null ? other.getLastLogin() == null : this.getLastLogin().equals(other.getLastLogin()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getExpire() == null ? other.getExpire() == null : this.getExpire().equals(other.getExpire()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getLoginPassword() == null) ? 0 : getLoginPassword().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getRegTime() == null) ? 0 : getRegTime().hashCode());
        result = prime * result + ((getLastLogin() == null) ? 0 : getLastLogin().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getExpire() == null) ? 0 : getExpire().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mobile=").append(mobile);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", nickname=").append(nickname);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", regTime=").append(regTime);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", token=").append(token);
        sb.append(", expire=").append(expire);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}