package com.ming.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class DataSourceHandler implements DataSourceFactory {
	Properties properties;
	DataSource dataSource = null;
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public DataSource getDataSource() {
		if (dataSource == null){
			try {
				return DruidDataSourceFactory.createDataSource(properties);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("=============================================================>已获取链接池");
		return dataSource;
	}
}
