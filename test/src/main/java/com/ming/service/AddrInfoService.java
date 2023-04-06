package com.ming.service;

import com.ming.dto.UserLoginDto;
import com.ming.entity.AddrInfo;
import com.ming.vo.Result;

public interface AddrInfoService extends BaseService<Integer, AddrInfo>{
	Result allAddrInfo();
}
