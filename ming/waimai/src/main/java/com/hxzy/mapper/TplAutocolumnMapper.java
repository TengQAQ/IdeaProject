package com.hxzy.mapper;

import com.hxzy.entity.TplAutocolumn;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【TPL_AUTOCOLUMN】的数据库操作Mapper
* @createDate 2023-04-20 22:39:12
* @Entity com.hxzy.entity.TplAutocolumn
*/
@Mapper
public interface TplAutocolumnMapper extends BaseMapper<TplAutocolumn,Long>{


    /**
     * @param tableName 通过表明查询保存数据
     * @return
     * @author QinTeng
     * @date 2023/4/20-22:43
     * @version 1.0
     * @description TODO
     */
    List<TplAutocolumn> findByTableName(String tableName);


    /***
     * @Description:根据表名清楚数据库数据
     * @Author: Ming
     * @Date: 2023/4/20 22:42
     * @params: [tableName]
     * @return: int
     **/
    @Delete(value = "delete from TPL_AUTOCOLUMN where \"TABLE_NAME\"=#{tableName}")
    int deleteByTableName(String tableName);


    /**
     * 根据表名，得到主键以及java数据类型
     * @param tableName
     * @return
     */
    TplAutocolumn searchTablePrimaryKeyAndJavaType(String tableName);
}
