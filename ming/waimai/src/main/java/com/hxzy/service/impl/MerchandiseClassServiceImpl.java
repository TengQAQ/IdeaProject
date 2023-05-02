package com.hxzy.service.impl;

import com.hxzy.dto.MerchandiseClassSearchDTO;
import com.hxzy.entity.MerchandiseClass;
import com.hxzy.service.BaseService;
import com.hxzy.service.MerchandiseClassService;
import com.hxzy.mapper.MerchandiseClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【MERCHANDISE_CLASS(商品分类表)】的数据库操作Service实现
* @createDate 2023-04-27 09:49:02
*/
@Service
public class MerchandiseClassServiceImpl extends BaseServiceImpl<MerchandiseClass,Integer> implements MerchandiseClassService{
    private MerchandiseClassMapper  merchandiseClassMapper;

    @Autowired
    public void setMerchandiseClassMapper(MerchandiseClassMapper merchandiseClassMapper) {
        this.merchandiseClassMapper = merchandiseClassMapper;
        super.setMapper(merchandiseClassMapper);
    }

    public List<MerchandiseClass> search(MerchandiseClassSearchDTO searchDTO) {
        return this.merchandiseClassMapper.search(searchDTO);
    }
}




