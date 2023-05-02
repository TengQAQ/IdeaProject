package com.hxzy.service;

import com.hxzy.dto.MerchandiseClassSearchDTO;
import com.hxzy.entity.MerchandiseClass;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【MERCHANDISE_CLASS(商品分类表)】的数据库操作Service
* @createDate 2023-04-27 09:49:02
*/

public interface MerchandiseClassService extends BaseService<MerchandiseClass, Integer> {

    /**
     * 分页查询
     * @param searchDTO
     * @return
     */
    List<MerchandiseClass> search(MerchandiseClassSearchDTO searchDTO);

}
