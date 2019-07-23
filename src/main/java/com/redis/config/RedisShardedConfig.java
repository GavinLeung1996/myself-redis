package com.redis.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

@Configuration  //标识我是一个配置类
@PropertySource("classpath:/properties/redis.properties")
public class RedisShardedConfig {

    @Value("${redis.ShardsNodes}")
    private String nodes;

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    @Bean
    public ShardedJedisPool shardedJedisPool(){
        List<JedisShardInfo> list = new ArrayList<>();
        String[] strNodes = nodes.split(",");
        for (String strNode:strNodes
             ) {
            String[] node = strNode.split(":");
            String host = node[0].replace(" ","");
            int port = Integer.parseInt(node[1].replace(" ",""));
            list.add(new JedisShardInfo(host,port));
        }
        return new ShardedJedisPool(new GenericObjectPoolConfig(),list);
    }

    @Bean
    public ShardedJedis shardedJedis(){
        return shardedJedisPool.getResource();
    }
}
