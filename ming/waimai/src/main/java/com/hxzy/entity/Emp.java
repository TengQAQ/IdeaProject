package com.hxzy.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * null
 */
@Data
public class Emp implements Serializable {
    private BigDecimal id;

    private String loginName;

    private String loginPwd;

    private Short gender;

    private Short status;

    private String avatar;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private static final long serialVersionUID = 1L;
}