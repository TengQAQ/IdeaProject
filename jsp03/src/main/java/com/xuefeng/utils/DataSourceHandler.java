package com.xuefeng.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class DataSourceHandler implements DataSourceFactory {
    private Properties properties;
    private DataSource dataSource;
    /**
     * mybatis在启动时，会自动将dataSource节点中<code>property</code>节点
     * 封装到Properties集合的对象
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public DataSource getDataSource() {
        if (this.dataSource == null) {
            try {
                // 根据mybatis配置的信息初始化Druid连接池
                this.dataSource = DruidDataSourceFactory.createDataSource(this.properties);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("----------------获取druid连接池----------------");
        return this.dataSource;
    }
}
