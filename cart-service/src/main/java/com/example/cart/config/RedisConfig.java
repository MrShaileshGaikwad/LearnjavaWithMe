package com.example.cart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.*;

import com.example.cart.dto.CartDto;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // For local dev
        return new LettuceConnectionFactory("localhost", 6379);
    }

    @Bean
    public RedisTemplate<String, CartDto> cartRedisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, CartDto> template = new RedisTemplate<>();
        template.setConnectionFactory(cf);
        return template;
    }
}
