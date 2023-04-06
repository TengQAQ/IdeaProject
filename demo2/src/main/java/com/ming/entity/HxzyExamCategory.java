package com.ming.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @TableName hxzy_exam_category
 */
public class HxzyExamCategory implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 上级分类编号
     */
    private String parentId;

    /**
     * 分类名
     */
    private String name;

    /**
     * 是否被删除，默认为0
     */
    private Integer isDel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后一次修改时间
     */
    private Date modifyTime;

    private List<HxzyExamCategory>  children;

    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 上级分类编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 上级分类编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 分类名
     */
    public String getName() {
        return name;
    }

    /**
     * 分类名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 是否被删除，默认为0
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 是否被删除，默认为0
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后一次修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后一次修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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
        HxzyExamCategory other = (HxzyExamCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        return result;
    }

    public List<HxzyExamCategory> getChildren() {
        return children;
    }

    public void setChildren(List<HxzyExamCategory> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "HxzyExamCategory{" +
                "id=" + id +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", isDel=" + isDel +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", children=" + children +
                '}';
    }
}