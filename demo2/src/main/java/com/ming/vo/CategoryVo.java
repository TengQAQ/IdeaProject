package com.ming.vo;

import com.ming.entity.HxzyExamCategory;

import java.util.Date;
import java.util.List;

public class CategoryVo {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 上级分类编号
	 */
	private Integer parentId;

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

	private List<CategoryVo> children;

	@Override
	public String toString() {
		return "CategoryVo{" +
				"id=" + id +
				", parentId='" + parentId + '\'' +
				", name='" + name + '\'' +
				", isDel=" + isDel +
				", createTime=" + createTime +
				", modifyTime=" + modifyTime +
				", children=" + children +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryVo)) return false;

		CategoryVo that = (CategoryVo) o;

		return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public List<CategoryVo> getChildren() {
		return children;
	}

	public void setChildren(List<CategoryVo> children) {
		this.children = children;
	}
}
