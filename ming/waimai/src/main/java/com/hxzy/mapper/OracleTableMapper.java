package com.hxzy.mapper;

import com.hxzy.vo.back.TableNameColumnsVO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/13-21:15
 * @description TODO
 */
@Mapper
public interface OracleTableMapper {
    /**
     * 查询当前数据库所有的表
     * @MapKey的作用是在返回一个Map的时候，Map的key将映射成注解中的值的字段,从而使map变相可以作为List使用.
     * @return
     */
    @MapKey(value = "rownum")
    List<Map<String,Object>> searchAllTables();

    /**
     * 根据表名查询所有列的信息
     * @param tableName
     * @MapKey的作用是在返回一个Map的时候，Map的key将映射成注解中的值的字段,从而使map变相可以作为List使用.
     * @return
     */
    @MapKey(value = "rownum")
    List<TableNameColumnsVO> columnsForTableName(String tableName);
}
