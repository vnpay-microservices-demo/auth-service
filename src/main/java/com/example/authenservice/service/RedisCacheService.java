package com.example.authenservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Value("${application.authentication.access_token.life_time}")
    private long expiredTime;
    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key,value,expiredTime, TimeUnit.MILLISECONDS);
    }
    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
