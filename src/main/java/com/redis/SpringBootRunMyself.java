package com.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//容器启动时不要加载数据源的相关配置
@SpringBootApplication
public class SpringBootRunMyself {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootRunMyself.class,args);
	}
}
