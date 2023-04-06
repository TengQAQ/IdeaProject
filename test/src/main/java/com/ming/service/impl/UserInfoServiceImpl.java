package com.ming.service.impl;

import com.ming.dto.UserLoginDto;
import com.ming.entity.UserInfo;
import com.ming.mapper.UserInfoMapper;
import com.ming.mapper.impl.UserInfoMapperImpl;
import com.ming.service.UserInfoService;
import com.ming.util.JedisPoolUtils;
import com.ming.util.MD5Utils;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoMapper mapper = new UserInfoMapperImpl();
	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return Result.of(mapper.deleteByPrimaryKey(id),"删除失败");
	}

	@Override
	public Result insert(UserInfo record) {
		return Result.of(mapper.insert(record),"新增失败");
	}

	@Override
	public Result insertSelective(UserInfo record) {
		return Result.of(mapper.insertSelective(record),"动态新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result;
		UserInfo employee = mapper.selectByPrimaryKey(id);
		if (employee.equals(null)){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(employee);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(UserInfo record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record),"动态修改失败");
	}

	@Override
	public Result updateByPrimaryKey(UserInfo record) {
		return Result.of(mapper.updateByPrimaryKey(record),"修改失败");
	}

	@Override
	public Result logOut(String token) {
		return Result.of(mapper.logOut(token),"退出失败");
	}

	@Override
	public Result selectByNickName(String name) {
		Result result;
		UserInfo userInfo = mapper.selectByNickName(name);
		if (userInfo == null){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(userInfo);
		}
		return result;
	}

	@Override
	public Result selectByToken(String token) {
		Result result;
		UserInfo userInfo = mapper.selectByToken(token);
		System.out.println(userInfo.toString());
		if (userInfo.equals(null)) {
			result = Result.of(CodeEnum.ILLEGAL_TOKEN);
		} else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(userInfo);
		}
		return result;
	}

	@Override
	public Result login(UserLoginDto dto) {
		UserInfo userInfo = mapper.selectByNickName(dto.getUsername());
		if (!(userInfo == null)){
			// 获取加密后的密码
			String rolePassword = userInfo.getLoginPassword();
			// 校验密码
			boolean verify = MD5Utils.getSaltverifyMD5(dto.getPassword(), rolePassword);
			if (verify) { // 密码正确
				// 根据UUID生成令牌
				String token = UUID.randomUUID().toString().replaceAll("-","");
				// 令牌有效时间30分钟
				long currentTimeMillis = System.currentTimeMillis();
//				// 当前时间+30分钟的毫秒数得到30分钟后的时间
				long expire = currentTimeMillis + TimeUnit.MINUTES.toMillis(30);
				System.out.println("用户密码正确输出：" + dto.getAdminUserId());

				UserInfo info = new UserInfo();
				info.setId(userInfo.getId());
				info.setMobile(userInfo.getMobile());
				info.setLoginPassword(userInfo.getLoginPassword());
				info.setNickname(userInfo.getNickname());
				info.setEmail(userInfo.getEmail());
				info.setSex(userInfo.getSex());
				info.setRegTime(userInfo.getRegTime());
				info.setToken(token);
				info.setExpire(new Date(expire));
				info.setLastLogin(new Date(currentTimeMillis));
				System.out.println(info.toString());
//
				mapper.updateByPrimaryKeySelective(info);

				try (Jedis jedis = JedisPoolUtils.getJedis()) {
					String key = "user:token:" + token;
					// 得到30分钟的秒数
					long seconds = TimeUnit.MINUTES.toSeconds(30);

					// 将token保存到redis,并设置有效时间30分钟
					jedis.setex(key, seconds, token);
				}

				// 将登录信息插入到user_token表前验证数据库中是否存在
//				mapper.updateByPrimaryKeySelective(info);
//				System.out.println("新增结果显示："+selective);

				Map<String, Object> map = new HashMap<>();
				map.put("token", token);
				map.put("name",userInfo.getNickname());
				map.put("id",userInfo.getId());
//				map.put("avatar",userInfo.());
				Result result = Result.of(CodeEnum.SUCCESS);
				result.setData(map);

				return result;
			} else { // 密码错误
				return Result.of(CodeEnum.UID_PWD_WRONG);
			}

		} else { // 用户名不存在
			return Result.of(CodeEnum.UID_PWD_WRONG);
		}
	}
}