package com.hxzy.service.impl;

import com.hxzy.dto.UserLoginDto;
import com.hxzy.entity.HxzyExamAdminUser;
import com.hxzy.entity.HxzyExamAdminUserToken;
import com.hxzy.mapper.HxzyExamAdminUserMapper;
import com.hxzy.mapper.HxzyExamAdminUserTokenMapper;
import com.hxzy.mapper.impl.HxzyExamAdminUserMapperImpl;
import com.hxzy.mapper.impl.HxzyExamAdminUserTokenMapperImpl;
import com.hxzy.service.HxzyExamAdminUserService;
import com.hxzy.utils.MD5Utils;
import com.hxzy.vo.CodeEnum;
import com.hxzy.vo.Result;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class HxzyExamAdminUserServiceImpl implements HxzyExamAdminUserService {
    private final HxzyExamAdminUserMapper mapper = new HxzyExamAdminUserMapperImpl();
    private final HxzyExamAdminUserTokenMapper tokenMapper = new HxzyExamAdminUserTokenMapperImpl();

    @Override
    public Result deleteByPrimaryKey(Long id) {
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
    public Result selectByPrimaryKey(Long id) {
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
    public Result login(UserLoginDto dto) {
        // 根据用户名查询用户
        HxzyExamAdminUser hxzyExamAdminUser = mapper.selectByUserName(dto.getUsername());
        if (hxzyExamAdminUser != null) { // 用户名存在
            // 获取加密后的密码
            String loginPassword = hxzyExamAdminUser.getLoginPassword();
            // 校验密码
            boolean verify = MD5Utils.getSaltverifyMD5(dto.getPassword(), loginPassword);
            if (verify) { // 密码正确
                if (hxzyExamAdminUser.getLocked().compareTo(0) == 0) { // 用户状态正常
                    // 根据UUID生成令牌
                    String token = UUID.randomUUID().toString().replaceAll("-", "");
                    // 令牌有效时间30分钟
                    long currentTimeMillis = System.currentTimeMillis();
                    // 当前时间+30分钟的毫秒数得到30分钟后的时间
                    long expire = currentTimeMillis + TimeUnit.MINUTES.toMillis(30);
                    Date date = new Date(expire);

                    HxzyExamAdminUserToken hxzyExamAdminUserToken = new HxzyExamAdminUserToken();
                    hxzyExamAdminUserToken.setToken(token);
                    hxzyExamAdminUserToken.setExpireTime(date);
                    hxzyExamAdminUserToken.setUpdateTime(new Date());
                    hxzyExamAdminUserToken.setUserName(hxzyExamAdminUser.getLoginUserName());
                    // 将登录信息插入到user_login表
                    int i = this.tokenMapper.insertSelective(hxzyExamAdminUserToken);

                    Map<String, Object> map = new HashMap<>();
                    map.put("token", token);

                    Result result = Result.of(CodeEnum.SUCCESS);
                    result.setData(map);

                    return result;
                } else { // 用户状态异常
                    return Result.of(CodeEnum.USER_BLOCKED_STATE);
                }
            } else { // 密码错误
                return Result.of(CodeEnum.INCORRECT_LOGIN_INFO);
            }

        } else { // 用户名不存在
            return Result.of(CodeEnum.INCORRECT_LOGIN_INFO);
        }
    }
}

