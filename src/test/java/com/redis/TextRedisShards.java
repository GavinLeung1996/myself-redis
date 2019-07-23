package com.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.ShardedJedis;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration

public class TextRedisShards {
//    测试Redis分片
    @Autowired
    private ShardedJedis jedis;

    @Test
    public void testRedisShards(){
        jedis.setex("test",20,"FirstTest");
        System.out.println(jedis.get("test"));
        jedis.close();
    }

}
