package com.hxzy.mapper;

import com.hxzy.dto.MerchandiseClassSearchDTO;
import com.hxzy.entity.MerchandiseClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【MERCHANDISE_CLASS(商品分类表)】的数据库操作Mapper
* @createDate 2023-04-27 09:49:02
* @Entity com.hxzy.entity.MerchandiseClass
*/
@Mapper
public interface MerchandiseClassMapper extends BaseMapper<Integer,MerchandiseClass> {
    /**
     * 分页查询
     * @param dto
     * @return
     */
    List<MerchandiseClass> search(@Param(value = "dto") MerchandiseClassSearchDTO dto);
}




