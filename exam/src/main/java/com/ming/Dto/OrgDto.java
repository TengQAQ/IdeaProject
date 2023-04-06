package com.ming.Dto;

import java.util.Date;

public class OrgDto {
	private String name;
	private Integer status;
	private Date createTime;
	private Integer level;
	private String parentRowKey;
	private Integer deptId; // 部门编号

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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getParentRowKey() {
		return parentRowKey;
	}

	public void setParentRowKey(String parentRowKey) {
		this.parentRowKey = parentRowKey;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "OrgDto{" +
				"name='" + name + '\'' +
				", status=" + status +
				", createTime=" + createTime +
				", level=" + level +
				", parentRowKey='" + parentRowKey + '\'' +
				", deptId=" + deptId +
				'}';
	}
}
