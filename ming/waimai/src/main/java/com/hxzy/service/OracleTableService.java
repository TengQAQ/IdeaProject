package com.hxzy.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/18-13:47
 * @description TODO
 */

public interface OracleTableService {
    /**
     * 查询当前数据库所有的表
     * @return
     */
    List<Map<String,Object>> searchAllTables();

    /**
     * 根据表名查询所有列的信息
     * @param tableName
     * @return
     */
    Map<String,Object> columnsForTableName(String tableName);

    /**
     * 生成zip文件并返回二进制数据
     * @param tableName
     * @param tableDesc
     * @return
     */
    byte[] generatorCode(String tableName, String tableDesc);
}
