package com.hxzy.mapper;

public interface BaseMapper<fk,model>{
    int deleteByPrimaryKey(fk id);

    int insert(model record);

    int insertSelective(model record);

    model selectByPrimaryKey(fk id);

    int updateByPrimaryKeySelective(model record);

    int updateByPrimaryKey(model record);
}
