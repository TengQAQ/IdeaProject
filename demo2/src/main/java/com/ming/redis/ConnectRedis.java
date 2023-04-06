package com.ming.redis;

import redis.clients.jedis.Jedis;

public class ConnectRedis {
	public static void main(String[] args) {
		//连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost",6379);//默认端口6379 可以省略
//       jedis.auth("redis");  //有密码此步需加上
		System.out.println("连接成功");

		//查看服务是否运行
		System.out.println("服务正在运行: "+jedis.ping());
		System.out.println(jedis.set("name","ming"));
		System.out.println(jedis.append("sex", "woman"));

	}
}
