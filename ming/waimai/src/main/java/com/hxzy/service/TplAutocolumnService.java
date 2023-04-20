package com.hxzy.service;
import com.hxzy.dto.TableNameSaveDTO;
import com.hxzy.entity.TplAutocolumn;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wy
 * @Description TODO
 * @Date 2023/4/8 14:52
 * @Version 1.0
 */
public interface TplAutocolumnService {

    /**
     * 根据表名查询字段
     * @param tableName
     * @return
     */
    List<TplAutocolumn> findByTableName(String tableName);


    /**
     * 把用户配置信息保存到数据库中
     * @param saveDTO
     * @return
     */
    boolean save(TableNameSaveDTO saveDTO);

    /**
     * 根据表名，得到主键以及java数据类型
     * @param tableName
     * @return
     */
    TplAutocolumn searchTablePrimaryKeyAndJavaType(String tableName);

}
