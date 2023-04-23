package com.hxzy.service.impl;

import com.hxzy.dto.ContamerSearchDTO;
import com.hxzy.entity.Cont;
import com.hxzy.mapper.ContMapper;
import com.hxzy.service.ContService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/13-0:28
 * @description TODO
 */
@Service
public class ContServiceImpl extends BaseServiceImpl<Cont,Long> implements ContService {
    @Autowired
    private ContMapper contMapper;

    @Override
    public List<Cont> search(ContamerSearchDTO dto) {
        return contMapper.search(dto);
    }
}
