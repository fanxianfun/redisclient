package com.fanxian;

import com.fanxian.redis.RedisActuator;
import java.util.Set;

public class App {
    public static void main( String[] args ) {

        RedisActuator redisActuator = new RedisActuator();

        redisActuator.execute(jedis -> jedis.set("foo", "bar"));

        String foobar = redisActuator.execute(jedis -> jedis.get("foo"));

        System.out.println(foobar);

        redisActuator.execute(jedis -> jedis.zadd("sose", 0, "car"));

        redisActuator.execute(jedis -> jedis.zadd("sose", 0, "bike"));

        Set<String> sose = redisActuator.execute(jedis -> jedis.zrange("sose", 0, -1));

        System.out.println(sose);
    }
}
