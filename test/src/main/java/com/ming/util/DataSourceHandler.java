package com.ming.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class DataSourceHandler implements DataSourceFactory {
	private Properties properties;
	private DataSource dataSource;
	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public DataSource getDataSource() {
		if (dataSource == null){
			try {
				return DruidDataSourceFactory.createDataSource(properties);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("===================>已获取DataSource");
		return dataSource;
	}
}
