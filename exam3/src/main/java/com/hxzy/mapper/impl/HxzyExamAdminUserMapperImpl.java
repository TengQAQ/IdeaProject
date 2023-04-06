package com.hxzy.mapper.impl;

import com.hxzy.entity.HxzyExamAdminUser;
import com.hxzy.mapper.HxzyExamAdminUserMapper;
import com.hxzy.utils.BaseHelper;

public class HxzyExamAdminUserMapperImpl extends BaseHelper implements HxzyExamAdminUserMapper {
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(HxzyExamAdminUser record) {
        return 0;
    }

    @Override
    public int insertSelective(HxzyExamAdminUser record) {
        return 0;
    }

    @Override
    public HxzyExamAdminUser selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(HxzyExamAdminUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(HxzyExamAdminUser record) {
        return 0;
    }

    @Override
    public HxzyExamAdminUser selectByUserName(String userName) {

        return super.query(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserMapper.class).selectByUserName(userName));
    }
}
