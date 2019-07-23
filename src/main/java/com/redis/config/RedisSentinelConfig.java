package com.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

@Configuration
@PropertySource("classpath:/properties/redis.properties")
public class RedisSentinelConfig {

    @Value("${redis.sentinels}")
    private String sentinels;

    @Value("${redis.sentinel.masterName}")
    private String masterName ;

    @Autowired
    private JedisSentinelPool jedisSentinelPool;

    @Bean
    public JedisSentinelPool jedisSentinelPool(){
        Set<String> set = new HashSet<>();
        set.add(sentinels);
        return new JedisSentinelPool(masterName,set);
    }

    @Bean
    public Jedis jedis(){
        return jedisSentinelPool.getResource();
    }
}
