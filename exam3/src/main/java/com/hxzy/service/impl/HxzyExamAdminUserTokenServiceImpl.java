package com.hxzy.service.impl;

import com.hxzy.entity.HxzyExamAdminUserToken;
import com.hxzy.mapper.HxzyExamAdminUserTokenMapper;
import com.hxzy.mapper.impl.HxzyExamAdminUserTokenMapperImpl;
import com.hxzy.service.HxzyExamAdminUserTokenService;
import com.hxzy.vo.CodeEnum;
import com.hxzy.vo.Result;

import java.util.HashMap;
import java.util.Map;

public class HxzyExamAdminUserTokenServiceImpl implements HxzyExamAdminUserTokenService {
   private HxzyExamAdminUserTokenMapper mapper  = new HxzyExamAdminUserTokenMapperImpl();
    @Override
    public Result deleteByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public Result insert(HxzyExamAdminUserToken record) {
        return null;
    }

    @Override
    public Result insertSelective(HxzyExamAdminUserToken record) {
        return null;
    }

    @Override
    public Result selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public Result updateByPrimaryKeySelective(HxzyExamAdminUserToken record) {
        return null;
    }

    @Override
    public Result updateByPrimaryKey(HxzyExamAdminUserToken record) {
        return null;
    }

    @Override
    public Result selectByToken(String token) {
        HxzyExamAdminUserToken hxzyExamAdminUserToken = mapper.selectByToken(token);

        if (hxzyExamAdminUserToken == null) {
            // 数据库不存在该token
            return Result.of(CodeEnum.ILLEGAL_TOKEN);
        }

        // 前端只要用户名和头像
        Map<String, Object> map = new HashMap<>();
        map.put("name", hxzyExamAdminUserToken.getUser().getLoginUserName());
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");

        Result result = Result.of(CodeEnum.SUCCESS);
        result.setData(map);

        return result;
    }

    @Override
    public Result logOut(String token) {
        int i = mapper.deleteByToken(token);
        return Result.of(i, "退出登录失败");
    }
}
