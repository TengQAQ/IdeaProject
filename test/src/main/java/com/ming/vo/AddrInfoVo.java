package com.ming.vo;

import com.ming.entity.AddrInfo;

import java.util.List;

public class AddrInfoVo extends AddrInfo {
	private List<AddrInfoVo> children;

	public List<AddrInfoVo> getChildren() {
		return children;
	}

	public void setChildren(List<AddrInfoVo> children) {
		this.children = children;
	}
}
