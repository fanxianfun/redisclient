package com.fanxian.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import java.util.function.Function;

public class RedisActuator {

    private JedisPool jedisPool = RedisConf.getJedisPool();

    public  <R> R execute(Function<Jedis, R> fun) {
        try (Jedis jedis = jedisPool.getResource()){
            return fun.apply(jedis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
