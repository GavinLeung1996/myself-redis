package com.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TextRedisCluster {
//    测试Redis集群
    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void testRedisCluster() {
        jedisCluster.setex("Test",20,"FirstTest");
        System.out.println(jedisCluster.get("Test"));
    }

}
