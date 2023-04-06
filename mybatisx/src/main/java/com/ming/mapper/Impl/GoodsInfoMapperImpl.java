package com.ming.mapper.Impl;

import com.ming.entity.GoodsInfo;
import com.ming.mapper.GoodsInfoMapper;
import com.ming.utils.BaseMapperHelper;
import com.ming.utils.SqlsessionHelper;
import org.apache.ibatis.session.SqlSession;

public class GoodsInfoMapperImpl extends BaseMapperHelper implements GoodsInfoMapper {
	public int deleteByPrimaryKey(Long id) {
		try(SqlSession session = SqlsessionHelper.opensqlsession()){
			GoodsInfoMapper  mapper = session.getMapper(GoodsInfoMapper.class);
			return mapper.deleteByPrimaryKey(id);
		}
	}

	public int insert(GoodsInfo goodsInfo) {
//		try(SqlSession session =SqlsessionHelper.opensqlsession()){
//			GoodsInfoMapper mapper = session.getMapper(GoodsInfoMapper.class);
//			return mapper.insert(goodsInfo);
//		}
		return dml(sqlSession -> sqlSession.getMapper(GoodsInfoMapper.class).insert(goodsInfo));
	}

	public int insertSelective(GoodsInfo record) {
		try(SqlSession session =SqlsessionHelper.opensqlsession()){
			GoodsInfoMapper mapper = session.getMapper(GoodsInfoMapper.class);
			return mapper.insertSelective(record);
		}
	}

	public GoodsInfo selectByPrimaryKey(Long id) {
		try(SqlSession session =SqlsessionHelper.opensqlsession()){
			GoodsInfoMapper mapper = session.getMapper(GoodsInfoMapper.class);
			return mapper.selectByPrimaryKey(id);
		}
//		int dml = dml(sqlSession -> sqlSession.getMapper(GoodsInfoMapper.class).selectByPrimaryKey(id));
	}

	public int updateByPrimaryKeySelective(GoodsInfo record) {
		try(SqlSession session =SqlsessionHelper.opensqlsession()){
			GoodsInfoMapper mapper = session.getMapper(GoodsInfoMapper.class);
			return mapper.updateByPrimaryKeySelective(record);
		}
	}

	public int updateByPrimaryKey(GoodsInfo record) {
		try(SqlSession session =SqlsessionHelper.opensqlsession()){
			GoodsInfoMapper mapper = session.getMapper(GoodsInfoMapper.class);
			return mapper.updateByPrimaryKey(record);
		}
	}
}
