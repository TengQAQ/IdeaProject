package com.ming.service;

import com.ming.entity.Politicsstatus;
import com.ming.vo.Result;

import java.util.List;

public interface PoliticsstatusService extends BaseService<Integer, Politicsstatus>{
	Result allPoliticsstatus();
}
