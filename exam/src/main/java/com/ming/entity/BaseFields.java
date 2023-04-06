package com.ming.entity;

import java.util.Date;
import java.util.Objects;

public class BaseFields {
	private Integer id;
	private String name;
	private Integer status;
	private Date createTime;
	private Date updateTime;
	private Integer level;
	// 为前端准备的一个针对于每条数据的唯一值；
	// 因为组织，公司，部门这三个类都有id属性，id值有重复
	private String rowKey;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRowKey() {
		return rowKey;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BaseFields that = (BaseFields) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Organization{" +
				"id=" + id +
				", name='" + name + '\'' +
				", status=" + status +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", level=" + level +
				'}';
	}
}
