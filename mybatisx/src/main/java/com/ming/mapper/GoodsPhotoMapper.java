package com.ming.mapper;

import com.ming.entity.GoodsPhoto;

/**
* @author QinTeng
* @description 针对表【goods_photo】的数据库操作Mapper
* @createDate 2023-02-10 12:41:10
* @Entity com.ming.entity.GoodsPhoto
*/
public interface GoodsPhotoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(GoodsPhoto record);

    int insertSelective(GoodsPhoto record);

    GoodsPhoto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsPhoto record);

    int updateByPrimaryKey(GoodsPhoto record);

}
