package com.fanxian.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConf {

    private static JedisPool pool;

    private RedisConf(){}

    static {
        pool = new JedisPool(new JedisPoolConfig(), "192.168.100.15",6379,60000,"bc_13579",13);
    }

    public static JedisPool getJedisPool() {
        return pool;
    }
}
