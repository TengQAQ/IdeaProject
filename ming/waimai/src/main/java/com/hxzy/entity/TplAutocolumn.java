package com.hxzy.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/18-14:00
 * @description TODO
 */
@Data
public class TplAutocolumn implements Serializable {
    private Long id;

    private Long num;

    private String columnName;

    private String dataType;

    private BigDecimal dataLength;

    private String comments;

    private String javaField;

    private String javaDataType;

    private Long vueType;

    private String convertValue;

    private Boolean searchField;

    private Boolean tableField;

    private String tableName;

    private static final long serialVersionUID = 1L;

}
