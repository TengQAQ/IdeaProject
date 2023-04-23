package com.hxzy.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * 
 * @author QinTeng
 * @TableName TPL_AUTOCOLUMN
 */
@Data
public class TplAutocolumn implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long num;

    /**
     * 
     */
    private String columnName;

    /**
     * 
     */
    private String dataType;

    /**
     * 
     */
    private BigDecimal dataLength;

    /**
     * 
     */
    private String comments;

    /**
     * 
     */
    private String javaField;

    /**
     * 
     */
    private String javaDataType;

    /**
     * 
     */
    private Long vueType;

    /**
     * 
     */
    private String convertValue;

    /**
     *
     */
    private Boolean searchField;

    private Boolean tableField;

    /**
     * 
     */
    private String tableName;

    private static final long serialVersionUID = 1L;

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
        TplAutocolumn other = (TplAutocolumn) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getColumnName() == null ? other.getColumnName() == null : this.getColumnName().equals(other.getColumnName()))
            && (this.getDataType() == null ? other.getDataType() == null : this.getDataType().equals(other.getDataType()))
            && (this.getDataLength() == null ? other.getDataLength() == null : this.getDataLength().equals(other.getDataLength()))
            && (this.getComments() == null ? other.getComments() == null : this.getComments().equals(other.getComments()))
            && (this.getJavaField() == null ? other.getJavaField() == null : this.getJavaField().equals(other.getJavaField()))
            && (this.getJavaDataType() == null ? other.getJavaDataType() == null : this.getJavaDataType().equals(other.getJavaDataType()))
            && (this.getVueType() == null ? other.getVueType() == null : this.getVueType().equals(other.getVueType()))
            && (this.getConvertValue() == null ? other.getConvertValue() == null : this.getConvertValue().equals(other.getConvertValue()))
            && (this.getSearchField() == null ? other.getSearchField() == null : this.getSearchField().equals(other.getSearchField()))
            && (this.getTableField() == null ? other.getTableField() == null : this.getTableField().equals(other.getTableField()))
            && (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getColumnName() == null) ? 0 : getColumnName().hashCode());
        result = prime * result + ((getDataType() == null) ? 0 : getDataType().hashCode());
        result = prime * result + ((getDataLength() == null) ? 0 : getDataLength().hashCode());
        result = prime * result + ((getComments() == null) ? 0 : getComments().hashCode());
        result = prime * result + ((getJavaField() == null) ? 0 : getJavaField().hashCode());
        result = prime * result + ((getJavaDataType() == null) ? 0 : getJavaDataType().hashCode());
        result = prime * result + ((getVueType() == null) ? 0 : getVueType().hashCode());
        result = prime * result + ((getConvertValue() == null) ? 0 : getConvertValue().hashCode());
        result = prime * result + ((getSearchField() == null) ? 0 : getSearchField().hashCode());
        result = prime * result + ((getTableField() == null) ? 0 : getTableField().hashCode());
        result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", num=").append(num);
        sb.append(", columnName=").append(columnName);
        sb.append(", dataType=").append(dataType);
        sb.append(", dataLength=").append(dataLength);
        sb.append(", comments=").append(comments);
        sb.append(", javaField=").append(javaField);
        sb.append(", javaDataType=").append(javaDataType);
        sb.append(", vueType=").append(vueType);
        sb.append(", convertValue=").append(convertValue);
        sb.append(", searchField=").append(searchField);
        sb.append(", tableField=").append(tableField);
        sb.append(", tableName=").append(tableName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}