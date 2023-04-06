package com.hxzy.service;

import com.hxzy.entity.Occupation;
import com.hxzy.vo.Result;

public interface OccupationService extends BaseService<Integer, Occupation>{

	Result selectAll(String table);
}
