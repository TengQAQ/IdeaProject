package com.hxzy.mapper.impl;

import com.hxzy.entity.HxzyExamAdminUserToken;
import com.hxzy.mapper.HxzyExamAdminUserTokenMapper;
import com.hxzy.utils.BaseHelper;

public class HxzyExamAdminUserTokenMapperImpl extends BaseHelper implements HxzyExamAdminUserTokenMapper {
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(HxzyExamAdminUserToken record) {
        return 0;
    }

    @Override
    public int insertSelective(HxzyExamAdminUserToken record) {
        return super.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).insertSelective(record));
    }

    @Override
    public HxzyExamAdminUserToken selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(HxzyExamAdminUserToken record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(HxzyExamAdminUserToken record) {
        return 0;
    }

    @Override
    public HxzyExamAdminUserToken selectByToken(String token) {

        return super.query(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).selectByToken(token));
    }

    @Override
    public int deleteByToken(String token) {

        return super.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).deleteByToken(token));

    }
}
