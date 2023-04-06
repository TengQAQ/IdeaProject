package com.ming.util;

import org.apache.ibatis.session.SqlSession;

import java.util.function.Function;

public class SqlSessionHelper {
	/**
	 * 适用于通用的增，删，改
	 * 在执行增、删、改操作时，执行的代码大部分是完全相同的
	 * 只有在获取mybatis代理对象以及执行具体的方法时是有区别的
	 * 因此将获取代理对象以及执行具体的DML方法的代码交给外部的调用者
	 *
	 * @param sessionFunction
	 * @return
	 */
	public static Integer dml(Function<SqlSession,Integer> sessionFunction){
		SqlSession session = null;
		try {
			// 得到SqlSession对象
			session = MySqlSessionFactory.opensqlsession();

			// 将session交给方法的调用者执行sql语句，并得到数据库受影响的行数
			Integer apply = sessionFunction.apply(session);

			// 提交事务
			session.commit();
			// 最终返回结果
			return apply;
		} catch (Exception e) {
			if(session != null)
				// 发生异常回滚事务
				session.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return 0;
	}

	public static <T> T query(Function<SqlSession , T> sessionTFunction) {
		try(SqlSession session = MySqlSessionFactory.opensqlsession()){
			return sessionTFunction.apply(session);
		}
	}
}
