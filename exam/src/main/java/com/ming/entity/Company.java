package com.ming.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 
 * @TableName company
 */
public class Company extends BaseFields implements Serializable {
	// 公司的下属部门
	private List<Department> children;

	@Override
	public String getRowKey() {

		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return "company:" + super.getId() + ":" + uuid;
	}

	public List<Department> getChildren() {
		return children;
	}

	public void setChildren(List<Department> children) {
		this.children = children;
	}
}