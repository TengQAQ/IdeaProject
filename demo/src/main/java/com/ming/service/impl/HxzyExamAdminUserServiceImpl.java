package com.ming.service.impl;

import com.ming.dto.UserLoginDto;
import com.ming.entity.HxzyExamAdminUser;
import com.ming.entity.HxzyExamAdminUserToken;
import com.ming.mapper.HxzyExamAdminUserMapper;
import com.ming.mapper.impl.HxzyExamAdminUserMapperImpl;
import com.ming.mapper.impl.HxzyExamAdminUserTokenMapperImpl;
import com.ming.service.HxzyExamAdminUserService;
import com.ming.service.HxzyExamAdminUserTokenService;
import com.ming.utils.MD5Utils;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class HxzyExamAdminUserServiceImpl implements HxzyExamAdminUserService {
	private HxzyExamAdminUserMapper mapper = new HxzyExamAdminUserMapperImpl();
	private Result result;
	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public Result insert(HxzyExamAdminUser record) {
		return null;
	}

	@Override
	public Result insertSelective(HxzyExamAdminUser record) {
		return null;
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public Result updateByPrimaryKeySelective(HxzyExamAdminUser record) {
		return null;
	}

	@Override
	public Result updateByPrimaryKey(HxzyExamAdminUser record) {
		return null;
	}

	@Override
	public Result selectByUserName(String name) {
		HxzyExamAdminUser hxzyExamAdminUser = mapper.selectByUserName(name);
		if (hxzyExamAdminUser == null){
			result= Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(hxzyExamAdminUser);
		}
		return result;
	}

	@Override
	public Result login(UserLoginDto dto) {
		HxzyExamAdminUserTokenMapperImpl hxzyExamAdminUserTokenMapper = new HxzyExamAdminUserTokenMapperImpl();
		HxzyExamAdminUserToken hxzyExamAdminUserToken = new HxzyExamAdminUserToken();

		HxzyExamAdminUser hxzyExamAdminUser = mapper.selectByUserName(dto.getUsername());
		if (hxzyExamAdminUser != null) { // 用户名存在
			// 获取加密后的密码
			String loginPassword = (hxzyExamAdminUser.getLoginPassword());
			// 校验密码
			boolean verify = MD5Utils.getSaltverifyMD5(dto.getPassword(), loginPassword);
			if (verify) { // 密码正确
				if (hxzyExamAdminUser.getLocked().equals(0)){
					// 插入数据
					String uuid = UUID.randomUUID().toString().replace("-", "");
					Long expire = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30);

					hxzyExamAdminUserToken.setUserName(dto.getUsername());
					hxzyExamAdminUserToken.setToken(uuid);
					hxzyExamAdminUserToken.setExpireTime(new Date(expire));
					hxzyExamAdminUserToken.setUpdateTime(new Date(System.currentTimeMillis()));

					hxzyExamAdminUserTokenMapper.insert(hxzyExamAdminUserToken);

					result = Result.of(CodeEnum.SUCCESS);
					Map<String,Object> map = new HashMap<>();
					map.put("id",hxzyExamAdminUser.getAdminUserId());
					map.put("token",hxzyExamAdminUserToken.getToken());
					map.put("name",hxzyExamAdminUserToken.getUserName());
					map.put("avatar",hxzyExamAdminUser.getLocked());
					result.setData(map);
					return result;
				}else {
					return Result.of(CodeEnum.USER_BROKING);
				}
			} else { // 用户状态异常
				return Result.of(CodeEnum.UID_PWD_WRONG);
			}
		} else {
			return Result.of(CodeEnum.UID_PWD_WRONG);
		}
	}
}
