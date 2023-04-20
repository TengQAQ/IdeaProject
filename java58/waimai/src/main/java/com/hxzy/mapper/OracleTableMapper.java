package com.hxzy.mapper;

import com.hxzy.vo.back.TableNameColumnsVO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author wy
 * @Description TODO
 * @Date 2023/4/8 10:01
 * @Version 1.0
 */
@Mapper
public interface OracleTableMapper {

    /**
     * 查询当前数据库所有的表
     * @return
     */
    @MapKey(value = "rownum")
    List<Map<String,Object>>  searchAllTables();

    /**
     * 根据表名查询所有列的信息
     * @param tableName
     * @return
     */
    @MapKey(value = "rownum")
    List<TableNameColumnsVO> columnsForTableName(String tableName);

}
