package com.hxzy.entity;

import java.io.Serializable;

/**
 * 通用信息表
 * @TableName other
 */
public class Other implements Serializable {
    /**
     * 主键自增长
     */
    private Integer otherId;

    /**
     * 值
     */
    private String otherName;

    /**
     * 表名
     */
    private String tableName;

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增长
     */
    public Integer getOtherId() {
        return otherId;
    }

    /**
     * 主键自增长
     */
    public void setOtherId(Integer otherId) {
        this.otherId = otherId;
    }

    /**
     * 值
     */
    public String getOtherName() {
        return otherName;
    }

    /**
     * 值
     */
    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    /**
     * 表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
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
        Other other = (Other) that;
        return (this.getOtherId() == null ? other.getOtherId() == null : this.getOtherId().equals(other.getOtherId()))
            && (this.getOtherName() == null ? other.getOtherName() == null : this.getOtherName().equals(other.getOtherName()))
            && (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOtherId() == null) ? 0 : getOtherId().hashCode());
        result = prime * result + ((getOtherName() == null) ? 0 : getOtherName().hashCode());
        result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", otherId=").append(otherId);
        sb.append(", otherName=").append(otherName);
        sb.append(", tableName=").append(tableName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}