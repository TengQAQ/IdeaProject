package com.hxzy.mapper;

import com.hxzy.entity.Other;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【other(通用信息表)】的数据库操作Mapper
* @createDate 2023-03-06 14:18:06
* @Entity com.hxzy.entity.Other
*/
public interface OtherMapper extends BaseMapper<Integer,Other>{

	List<Other> selectByTable(@Param("tableName") String tableName);

}
