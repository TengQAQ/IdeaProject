package com.hxzy.service.impl;

import com.hxzy.dto.MerchandiserSearchDTO;
import com.hxzy.entity.Merchandiser;
import com.hxzy.mapper.MerchandiserMapper;
import com.hxzy.service.MerchandiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/5/3-16:13
 * @description TODO
 */
@Service
public class MerchandiserServiceImpl extends BaseServiceImpl<Merchandiser,Long> implements MerchandiserService {

    private MerchandiserMapper merchandiserMapper;

    @Autowired
    public void setMerchandiserMapper(MerchandiserMapper merchandiserMapper) {
        this.merchandiserMapper = merchandiserMapper;
        super.setMapper(merchandiserMapper);
    }

    @Override
    public List<Merchandiser> search(MerchandiserSearchDTO searchDTO) {
        return this.merchandiserMapper.search(searchDTO);
    }

    @Override
    public boolean existsLoginName(String loginName) {
        return this.merchandiserMapper.existsLoginName(loginName) > 0;
    }
}
