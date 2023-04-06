package com.ming.service;

import com.ming.entity.Nation;
import com.ming.vo.Result;

public interface NationService extends BaseService<Integer, Nation>{
	Result allNation();
}
