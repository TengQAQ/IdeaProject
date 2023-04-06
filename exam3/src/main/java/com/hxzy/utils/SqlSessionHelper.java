package com.hxzy.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionHelper {
    private static SqlSessionFactory factory;
    private static final String PATH = "mybatis-config.xml";
   static {
       try {
           Reader reader = Resources.getResourceAsReader(PATH);
         factory = new SqlSessionFactoryBuilder().build(reader);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   public static SqlSession openSession(){
     return   factory.openSession();
   }
}
