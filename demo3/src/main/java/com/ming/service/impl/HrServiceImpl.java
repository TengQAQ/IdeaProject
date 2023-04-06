package com.ming.service.impl;

import com.ming.dto.UserLoginDto;
import com.ming.entity.Hr;
import com.ming.entity.Hr;
import com.ming.entity.HrToken;
import com.ming.mapper.HrMapper;
import com.ming.mapper.HrTokenMapper;
import com.ming.mapper.impl.HrMapperImpl;
import com.ming.mapper.impl.HrTokenMapperImpl;
import com.ming.service.HrService;
import com.ming.util.JedisPoolUtils;
import com.ming.util.MD5Utils;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class HrServiceImpl implements HrService {
	private HrMapper mapper = new HrMapperImpl();
	private HrTokenMapper mapper2 = new HrTokenMapperImpl();

	@Override
	public Result deleteByPrimaryKey(String id) {
		return Result.of(mapper.deleteByPrimaryKey(id),"删除失败");
	}

	@Override
	public Result insert(Hr record) {
		return Result.of(mapper.insert(record),"新增失败");
	}

	@Override
	public Result insertSelective(Hr record) {
		return Result.of(mapper.insertSelective(record),"动态新增失败");
	}

	@Override
	public Result selectByPrimaryKey(String id) {
		Result result;
		Hr employee = mapper.selectByPrimaryKey(id);
		if (employee.equals(null)){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(employee);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(Hr record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record),"动态修改失败");
	}

	@Override
	public Result updateByPrimaryKey(Hr record) {
		return Result.of(mapper.updateByPrimaryKey(record),"修改失败");
	}

	@Override
	public Result login(UserLoginDto dto) {
		Hr hr = mapper.selectByPrimaryKey(dto.getUsername());
		if (!(hr == null)){
			// 获取加密后的密码
			String rolePassword = hr.getPassword();
			// 校验密码
			boolean verify = MD5Utils.getSaltverifyMD5(dto.getPassword(), rolePassword);
			if (verify) { // 密码正确
				if (hr.getEnabled().compareTo(1) == 0) { // 用户状态正常
					// 根据UUID生成令牌
					String token = UUID.randomUUID().toString().replaceAll("-","");
					// 令牌有效时间30分钟
					long currentTimeMillis = System.currentTimeMillis();
//					// 当前时间+30分钟的毫秒数得到30分钟后的时间
					long expire = currentTimeMillis + TimeUnit.MINUTES.toMillis(30);
					HrToken hrToken = new HrToken();
					System.out.println("用户密码正确输出：" + dto.getAdminUserId());
//					userLogin.setAdminUserId(dto.getAdminUserId());
					hrToken.setHrId(hr.getId().longValue());
					hrToken.setToken(token);
					hrToken.setExpireTime(new Date(expire));
					hrToken.setUpdateTime(new Date(currentTimeMillis));
					System.out.println(hrToken.toString());

					try (Jedis jedis = JedisPoolUtils.getJedis()) {
						String key = "user:token:" + token;
						// 得到30分钟的秒数
						long seconds = TimeUnit.MINUTES.toSeconds(30);

						// 将token保存到redis,并设置有效时间30分钟
						jedis.setex(key, seconds, token);
					}

					// 将登录信息插入到user_token表前验证数据库中是否存在
					HrToken token1 = mapper2.selectByPrimaryKey(hr.getId());
//					System.out.println("输出" + hrToken2.toString());
					if (token1 == null){
						int i = mapper2.insertSelective(hrToken);
//						return Result.of(i,"token操作失败");
					}else {
						mapper2.updateByPrimaryKeySelective(hrToken);
					}
//					System.out.println("新增结果显示："+selective);

					Map<String, Object> map = new HashMap<>();
					map.put("token", token);
					map.put("name",hr.getName());
					map.put("avatar",hr.getAvatar());
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
