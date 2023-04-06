package com.ming.mapper;

import com.ming.entity.GoodsPhoto;

/**
* @author QinTeng
* @description 针对表【goods_photo】的数据库操作Mapper
* @createDate 2023-02-12 12:37:14
* @Entity com.ming.entity.GoodsPhoto
*/
public interface GoodsPhotoMapper extends BaseMapper<Long,GoodsPhoto>{


	@Override
	default Long deleteByPrimaryKey(Long id) {
		return null;
	}

	@Override
	default Long insert(GoodsPhoto record) {
		return null;
	}

	@Override
	default Long insertSelective(GoodsPhoto record) {
		return null;
	}

	@Override
	default GoodsPhoto selectByPrimaryKey(Long id) {
		return null;
	}

	@Override
	default Long updateByPrimaryKeySelective(GoodsPhoto record) {
		return null;
	}

	@Override
	default Long updateByPrimaryKey(GoodsPhoto record) {
		return null;
	}
}
