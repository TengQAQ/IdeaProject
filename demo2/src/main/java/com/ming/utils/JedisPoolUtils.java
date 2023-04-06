package com.ming.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {
	// jedis连接池
	private static final JedisPool jedisPool;

	static{
		//获取输入流
		InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
		//创建properties对象
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//获取数据、设置到JedisPoolConfig中
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("redis.pool.maxTotal")));
		jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("redis.pool.maxIdle")));
		jedisPoolConfig.setMinIdle(Integer.parseInt(properties.getProperty("redis.pool.minIdle")));
		// 连接主机地址
		String host = properties.getProperty("redis.host");
		// 端口号
		Integer port = Integer.parseInt(properties.getProperty("redis.port"));
		// 超时时长
		Integer timeout = Integer.parseInt(properties.getProperty("redis.timeout"));
		// 连接密码
		// String auth = properties.getProperty("redis.auth");
		// jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,auth);

		// 创建redis连接池
		jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout);
	}

	/**
	 * 从连接池中获取连接的方法
	 */
	public static Jedis getJedis(){
		return jedisPool.getResource();
	}
}
