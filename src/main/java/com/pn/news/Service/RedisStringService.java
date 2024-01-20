package com.pn.news.Service;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisStringService {
    /**
    *专门用来存储值为字符串的Redis客户端
    */
    @Resource
    private StringRedisTemplate stringRedisTemplate;
}
