package com.ming.mapper;

import com.ming.entity.AddrInfo;
import com.ming.vo.AddrInfoVo;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【addr_info】的数据库操作Mapper
* @createDate 2023-03-30 10:15:59
* @Entity com.ming.entity.AddrInfo
*/
public interface AddrInfoMapper extends BaseMapper<Integer,AddrInfo> {

	List<AddrInfo> allAddrInfo();

	void selectByName(String username);
}
