package com.example.cart.service;

import com.example.cart.dto.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class CartCacheService {

    private final RedisTemplate<String, CartDto> redisTemplate;
    private static final String PREFIX = "cart:";

    public void putCart(CartDto cart) {
        String key = PREFIX + cart.getId();
        redisTemplate.opsForValue().set(key, cart, Duration.ofHours(24));
    }

    public CartDto getCart(String cartId) {
        return redisTemplate.opsForValue().get(PREFIX + cartId);
    }

    public void evictCart(String cartId) {
        redisTemplate.delete(PREFIX + cartId);
    }
}
