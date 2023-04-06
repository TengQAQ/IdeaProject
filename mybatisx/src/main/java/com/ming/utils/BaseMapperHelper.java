package com.ming.utils;

import org.apache.ibatis.session.SqlSession;

import java.util.function.Function;

public class BaseMapperHelper {
	public int dml(Function<SqlSession,Integer> sessionFfunction){
		SqlSession session = null;
		try {
			SqlsessionHelper.opensqlsession();

			Integer apply = sessionFfunction.apply(session);

			session.commit();

			return apply;
		} catch (Exception e) {
			if (session != null){
				session.rollback();
			}
			throw new RuntimeException(e);
		}finally {
			if (session!=null)session.close();
		}
	}
}
