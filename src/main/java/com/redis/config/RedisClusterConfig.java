package com.redis.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Configuration  //标识我是一个配置类
@PropertySource("classpath:/properties/redis.properties")
public class RedisClusterConfig {

    @Value("${redis.ClusterNodes}")
    private String nodes;

    @Bean
    public JedisCluster jedisCluster(){
        Set<HostAndPort> hostAndPort = getHost();
        return new JedisCluster(hostAndPort);
    }

    private Set<HostAndPort> getHost() {
        Set<HostAndPort> set = new HashSet<>();
        String[] strNodes = nodes.split(",");
        for (String node:strNodes
             ) {
            String host = node.split(":")[0];
            int port = Integer.parseInt(node.split(":")[1]);
            set.add(new HostAndPort(host,port));
        }
        return set;
    }
}