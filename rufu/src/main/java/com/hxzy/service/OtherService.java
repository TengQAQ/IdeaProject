package com.hxzy.service;

import com.hxzy.entity.Other;
import com.hxzy.vo.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OtherService extends BaseService{
	Result selectByTable(String tableName);
}
