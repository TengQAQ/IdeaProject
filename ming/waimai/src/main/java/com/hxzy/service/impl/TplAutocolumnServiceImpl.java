package com.hxzy.service.impl;

import com.hxzy.dto.TableNameSaveDTO;
import com.hxzy.entity.TplAutocolumn;
import com.hxzy.mapper.TplAutocolumnMapper;
import com.hxzy.service.TplAutocolumnService;
import com.hxzy.vo.back.TableNameColumnsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/18-22:54
 * @description TODO
 */
@Service
public class TplAutocolumnServiceImpl implements TplAutocolumnService {
    @Autowired
    TplAutocolumnMapper tplAutocolumnMapper;
    @Override
    public List<TplAutocolumn> findByTableName(String tableName) {
        return tplAutocolumnMapper.findByTableName(tableName);
    }

    /**
     * @param saveDTO
     * @return
     * 此方法是多表查询，所以需要开启事务保证其原子性
     * Transactional用于管理数据库事务。事务是一组操作，要么全部成功，要么全部失败。
     * 在一个事务中，所有的操作要么全部完成，要么全部回滚。
     * Transactional 提供了一种机制来确保事务的原子性、一致性、隔离性和持久性，从而保证了数据的完整性和可靠性。
     * 它可以用于控制数据库的读写操作，确保数据的完整性和一致性。同时，它也可以用于控制应用程序中的业务逻辑，确保事务的正确执行。
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(TableNameSaveDTO saveDTO) {
        this.tplAutocolumnMapper.deleteByTableName(saveDTO.getTableName());
        //保存
        for(TableNameColumnsVO vo: saveDTO.getColumns()){
            TplAutocolumn  tpl=new TplAutocolumn();

            BeanUtils.copyProperties(vo,tpl);

            tpl.setTableName(saveDTO.getTableName());
            //保存
            this.tplAutocolumnMapper.insert(tpl);
        }
        return true;
    }

    @Override
    public TplAutocolumn searchTablePrimaryKeyAndJavaType(String tableName) {
        return this.tplAutocolumnMapper.searchTablePrimaryKeyAndJavaType(tableName);
    }
}
