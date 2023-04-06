package com.hxzy.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * null
 */
@Data
public class Contamer implements Serializable {
    private Long id;

    private String loginName;

    private String password;

    private String userName;

    private Short gender;

    private String portrait;

    private Long status;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private static final long serialVersionUID = 1L;
}