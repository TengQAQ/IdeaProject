package com.hxzy.mapper;

import com.hxzy.entity.TplAutocolumn;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/18-13:55
 * @description TODO
 */
public interface TplAutocolumnMapper {
    List<TplAutocolumn> findByTableName(String tableName);


    @Delete(value = "delete from TPL_AUTOCOLUMN where \"TABLE_NAME\"=#{tableName}")
    int deleteByTableName(String tableName);


    /**
     * 根据表名，得到主键以及java数据类型
     * @param tableName
     * @return
     */
    TplAutocolumn searchTablePrimaryKeyAndJavaType(String tableName);
}
