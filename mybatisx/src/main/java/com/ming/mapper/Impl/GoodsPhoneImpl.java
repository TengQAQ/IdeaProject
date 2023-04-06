package com.ming.mapper.Impl;

import com.ming.entity.GoodsPhoto;
import com.ming.mapper.GoodsInfoMapper;
import com.ming.mapper.GoodsPhotoMapper;
import com.ming.utils.SqlsessionHelper;
import org.apache.ibatis.session.SqlSession;

public class GoodsPhoneImpl extends SqlsessionHelper implements GoodsPhotoMapper {
	public int deleteByPrimaryKey(Long id) {
		try(SqlSession session =SqlsessionHelper.opensqlsession()){
			GoodsPhotoMapper mapper = session.getMapper(GoodsPhotoMapper.class);
			return mapper.deleteByPrimaryKey(id);
		}
	}

	public int insert(GoodsPhoto record) {
		try(SqlSession session =SqlsessionHelper.opensqlsession()){
			GoodsPhotoMapper mapper = session.getMapper(GoodsPhotoMapper.class);
			return mapper.insert(record);
		}
	}

	public int insertSelective(GoodsPhoto record) {
		try(SqlSession session =SqlsessionHelper.opensqlsession()){
			GoodsPhotoMapper mapper = session.getMapper(GoodsPhotoMapper.class);
			return mapper.insertSelective(record);
		}
	}

	public GoodsPhoto selectByPrimaryKey(Long id) {
		try(SqlSession session =SqlsessionHelper.opensqlsession()){
			GoodsPhotoMapper mapper = session.getMapper(GoodsPhotoMapper.class);
			return mapper.selectByPrimaryKey(id);
		}
	}

	public int updateByPrimaryKeySelective(GoodsPhoto record) {
		try(SqlSession session =SqlsessionHelper.opensqlsession()){
			GoodsPhotoMapper mapper = session.getMapper(GoodsPhotoMapper.class);
			return mapper.updateByPrimaryKeySelective(record);
		}
	}

	public int updateByPrimaryKey(GoodsPhoto record) {
		try(SqlSession session =SqlsessionHelper.opensqlsession()){
			GoodsPhotoMapper mapper = session.getMapper(GoodsPhotoMapper.class);
			return mapper.updateByPrimaryKey(record);
		}
	}
}
