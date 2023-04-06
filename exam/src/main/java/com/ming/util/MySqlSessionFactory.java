package com.ming.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MySqlSessionFactory {
	private static String PATH="mybatis-config.xml";
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader(PATH);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static SqlSession opensqlsession(){
		return factory.openSession();
	}
}
