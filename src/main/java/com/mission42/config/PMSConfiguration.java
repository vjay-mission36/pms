package com.mission42.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class PMSConfiguration {
    RedisTemplate<String, String> radisTemplate(RedisConnectionFactory rcf) {
        RedisTemplate<String, String> rt = new RedisTemplate<>();
        rt.setConnectionFactory(rcf);
        return rt;
    }

    @Bean
    RedisConnectionFactory redisConnectionFactory(){
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().
     
    }
}
