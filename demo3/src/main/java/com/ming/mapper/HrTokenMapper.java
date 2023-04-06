package com.ming.mapper;

import com.ming.entity.HrToken;
import com.ming.vo.Result;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【hr_token(登录令牌表)】的数据库操作Mapper
* @createDate 2023-03-24 16:57:06
* @Entity com.ming.entity.HrToken
*/
public interface HrTokenMapper extends BaseMapper<Integer,HrToken>{
	HrToken selectByToken(String token);

	int logOut(String token);
}
