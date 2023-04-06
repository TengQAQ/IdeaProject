package com.hxzy.mapper;

import com.hxzy.entity.Occupation;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【occupation】的数据库操作Mapper
* @createDate 2023-03-06 21:54:43
* @Entity com.hxzy.entity.Occupation
*/
public interface OccupationMapper extends BaseMapper<Integer,Occupation>{


    List<Occupation> selectAll(String table);
}
