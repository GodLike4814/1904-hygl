package com.fh.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class RedisPool {
    //私有的静态全局变量
    private static JedisPool pool;

    //静态块中的方法    也就是java虚拟机在加载这个类的
    // 同时会加载一次静态块的代码
    //jedis连接池
      private static void  initPool(){
          JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
          jedisPoolConfig.setMaxTotal(1000);
          jedisPoolConfig.setMinIdle(8);
          jedisPoolConfig.setMaxIdle(16);
          jedisPoolConfig.setTestOnBorrow(false);
          jedisPoolConfig.setTestOnReturn(true);
          pool = new JedisPool(jedisPoolConfig,"192.168.196.129",6379);
      }
    static {
        initPool();
    }

    //私有的构造函数
    private RedisPool(){}

    //共有的静态方法
    public static Jedis getResource(){
          return pool.getResource();
    }
}
