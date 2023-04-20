package com.hxzy.service.impl;

import com.hxzy.dto.TableNameSaveDTO;
import com.hxzy.entity.TplAutocolumn;
import com.hxzy.service.TplAutocolumnService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/18-22:54
 * @description TODO
 */
@Service
public class TplAutocolumnServiceImpl implements TplAutocolumnService {
    @Override
    public List<TplAutocolumn> findByTableName(String tableName) {
        return null;
    }

    @Override
    public boolean save(TableNameSaveDTO saveDTO) {
        return false;
    }

    @Override
    public TplAutocolumn searchTablePrimaryKeyAndJavaType(String tableName) {
        return null;
    }
}
