package com.hxzy.utils;

import org.apache.ibatis.session.SqlSession;

import java.util.function.Function;

public class BaseHelper {
    SqlSession session =null;

    public int dml(Function<SqlSession,Integer> function){

        try {
            session =  SqlSessionHelper.openSession();
            Integer apply = function.apply(session);
            session.commit();
            return apply;

        } catch (Exception e) {

            session.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }
        return 0;
    }
 public  <T> T query(Function<SqlSession,T> function){
        try(
           SqlSession  session=  SqlSessionHelper.openSession()
                ){
            return function.apply(session);
        }

 }
}
