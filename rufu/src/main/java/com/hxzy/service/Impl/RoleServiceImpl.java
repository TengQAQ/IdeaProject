package com.hxzy.service.Impl;

import com.hxzy.Dto.UserLoginDto;
import com.hxzy.entity.Role;
import com.hxzy.entity.UserLogin;
import com.hxzy.mapper.Impl.RoleMapperImpl;
import com.hxzy.mapper.Impl.UserLoginMapperImpl;
import com.hxzy.mapper.RoleMapper;
import com.hxzy.mapper.UserLoginMapper;
import com.hxzy.service.RoleService;
import com.hxzy.util.MD5Utils;
import com.hxzy.vo.CodeEnum;
import com.hxzy.vo.Result;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RoleServiceImpl implements RoleService {
	private RoleMapper mapper = new RoleMapperImpl();
	private UserLoginMapper userLoginMapper = new UserLoginMapperImpl();

	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public Result insert(RoleMapper record) {
		return null;
	}

	@Override
	public Result insertSelective(RoleMapper record) {
		return null;
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result;
		Role role = mapper.selectByPrimaryKey(id);
		if (role == null){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(role);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(RoleMapper record) {
		return null;
	}

	@Override
	public Result updateByPrimaryKey(RoleMapper record) {
		return null;
	}

	@Override
	public Result login(UserLoginDto dto) {
		// 根据用户名查询用户
		Role role = mapper.selectByNumber(dto.getUsername());
		if (role != null) { // 用户名存在
			// 获取加密后的密码
			String rolePassword = role.getPassword();
			// 校验密码
			boolean verify = MD5Utils.getSaltVerifyMD5(dto.getPassword(), rolePassword);
			if (verify) { // 密码正确
				if (role.getStateId().compareTo(1) == 0) { // 用户状态正常
					// 根据UUID生成令牌
					String token = UUID.randomUUID().toString().replaceAll("-","");
					// 令牌有效时间30分钟
					long currentTimeMillis = System.currentTimeMillis();
					// 当前时间+30分钟的毫秒数得到30分钟后的时间
					long expire = currentTimeMillis + TimeUnit.MINUTES.toMillis(30);

					UserLogin userLogin = new UserLogin();
					userLogin.setToken(token);
					userLogin.setExpire(expire);
					userLogin.setRoleNumber(dto.getUsername());
					userLogin.setLastLoginTime(new Date());
					userLogin.setLastLoginIp(dto.getLoginIp());
					System.out.println(userLogin.toString());

					// 将登录信息插入到user_login表
					int selective = this.userLoginMapper.insertSelective(userLogin);
					System.out.println("新增结果显示："+selective);

					Map<String, Object> map = new HashMap<>();
					map.put("token", token);

					Result result = Result.of(CodeEnum.SUCCESS);
					result.setData(map);

					return result;
				} else { // 用户状态异常
					return Result.of(CodeEnum.USER_BROKING);
				}
			} else { // 密码错误
				return Result.of(CodeEnum.UID_PWD_WRONG);
			}

		} else { // 用户名不存在
			return Result.of(CodeEnum.UID_PWD_WRONG);
		}
	}

}