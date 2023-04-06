package com.ming.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName dept_relation
 */
public class DeptRelation implements Serializable {
    /**
     * 
     */
    private Object id;

    /**
     * 公司外键
     */
    private Integer companyId;

    /**
     * 部门外键
     */
    private Integer departmentId;

    /**
     * 状态（正常--1，注销--0）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer level;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Object getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Object id) {
        this.id = id;
    }

    /**
     * 公司外键
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 公司外键
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 部门外键
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * 部门外键
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 状态（正常--1，注销--0）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态（正常--1，注销--0）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建时间
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * 创建时间
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
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
     * 
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 
     */
    public void setLevel(Integer level) {
        this.level = level;
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
        DeptRelation other = (DeptRelation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatTime() == null ? other.getCreatTime() == null : this.getCreatTime().equals(other.getCreatTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatTime() == null) ? 0 : getCreatTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyId=").append(companyId);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", status=").append(status);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", level=").append(level);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}