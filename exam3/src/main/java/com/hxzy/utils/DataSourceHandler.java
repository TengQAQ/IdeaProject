package com.hxzy.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 给mybatis-config.xml读取用的
 * 用于获取连接池
 */
public class DataSourceHandler implements DataSourceFactory {
    private Properties properties;
    private DataSource dataSource;
    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;


    }

    @Override
    public DataSource getDataSource() {
        try {
            if(dataSource==null){
               return  DruidDataSourceFactory.createDataSource(this.properties);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("----------获取druid连接池-----------");
        return this .dataSource;
    }
}
