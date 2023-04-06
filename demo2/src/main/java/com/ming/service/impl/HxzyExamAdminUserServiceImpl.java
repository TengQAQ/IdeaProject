package com.ming.service.impl;

import com.ming.dto.UserLoginDto;
import com.ming.entity.HxzyExamAdminUser;
import com.ming.entity.HxzyExamAdminUserToken;
import com.ming.mapper.HxzyExamAdminUserMapper;
import com.ming.mapper.HxzyExamAdminUserTokenMapper;
import com.ming.mapper.impl.HxzyExamAdminUserMapperImpl;
import com.ming.mapper.impl.HxzyExamAdminUserTokenMapperImpl;
import com.ming.service.HxzyExamAdminUserService;
import com.ming.utils.JedisPoolUtils;
import com.ming.utils.MD5Utils;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class HxzyExamAdminUserServiceImpl implements HxzyExamAdminUserService {
	private HxzyExamAdminUserMapper mapper = new HxzyExamAdminUserMapperImpl();

	private HxzyExamAdminUserTokenMapper mapper2 = new HxzyExamAdminUserTokenMapperImpl();
	@Override
	public Result deleteByPrimaryKey(String id) {
		return Result.of(mapper.deleteByPrimaryKey(id),"删除失败");
	}

	@Override
	public Result insert(HxzyExamAdminUser record) {
		return Result.of(mapper.insert(record),"新增失败");
	}

	@Override
	public Result insertSelective(HxzyExamAdminUser record) {
		return Result.of(mapper.insertSelective(record),"新增失败");
	}

	@Override
	public Result selectByPrimaryKey(String id) {
		Result result;
		HxzyExamAdminUser hxzyExamAdminUser = mapper.selectByPrimaryKey(id);
		if (!(hxzyExamAdminUser == null)){
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(hxzyExamAdminUser);
			return result;
		}else {
			result = Result.of(CodeEnum.FAILURE);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(HxzyExamAdminUser record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record),"修改失败");
	}

	@Override
	public Result updateByPrimaryKey(HxzyExamAdminUser record) {
		return Result.of(mapper.updateByPrimaryKey(record),"修改失败");
	}

	@Override
	public Result login(UserLoginDto dto) {
		HxzyExamAdminUser hxzyExamAdminUser = mapper.login(dto.getUsername());
		if (!(hxzyExamAdminUser == null)){
			// 获取加密后的密码
			String rolePassword = hxzyExamAdminUser.getLoginPassword();
			// 校验密码
			boolean verify = MD5Utils.getSaltverifyMD5(dto.getPassword(), rolePassword);
			if (verify) { // 密码正确
				if (hxzyExamAdminUser.getLocked().compareTo(0) == 0) { // 用户状态正常
					// 根据UUID生成令牌
					String token = UUID.randomUUID().toString().replaceAll("-","");
					// 令牌有效时间30分钟
					long currentTimeMillis = System.currentTimeMillis();
//					// 当前时间+30分钟的毫秒数得到30分钟后的时间
					long expire = currentTimeMillis + TimeUnit.MINUTES.toMillis(30);
					HxzyExamAdminUserToken userLogin = new HxzyExamAdminUserToken();
					System.out.println(dto.getAdminUserId());
//					userLogin.setAdminUserId(dto.getAdminUserId());
					userLogin.setToken(token);
					userLogin.setExpireTime(new Date(expire));
					userLogin.setUpdateTime(new Date(currentTimeMillis));
					System.out.println(userLogin.toString());

					try (Jedis jedis = JedisPoolUtils.getJedis()) {
						String key = "user:token:" + token;
						// 得到30分钟的秒数
						long seconds = TimeUnit.MINUTES.toSeconds(30);

						// 将token保存到redis,并设置有效时间30分钟
						jedis.setex(key, seconds, token);
					}


					// 将登录信息插入到user_login表
					int selective = mapper2.insertSelective(userLogin);
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
