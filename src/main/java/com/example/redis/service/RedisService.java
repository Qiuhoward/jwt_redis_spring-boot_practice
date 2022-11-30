package com.example.redis.service;

import com.example.redis.bean.AddDto;
import com.example.redis.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final RedisTemplate<String,String> redisTemplate;
    private final JwtUtils jwtUtils;

    public RedisService(RedisTemplate<String, String> redisTemplate1,JwtUtils jwtUtils) {
        this.redisTemplate = redisTemplate1;
        this.jwtUtils = jwtUtils;
    }


    /**
     *  向redis里存入数据和设置缓存时间
     */
    public Claims add(AddDto addDto) {
        String token=JwtUtils.creatJWT(addDto,60000L);
        redisTemplate.opsForValue().set(addDto.getAccount(),addDto.getPassword());//秒
        System.out.println(token);
        Claims claims = com.example.redis.utils.JwtUtils.parseJWT(token);
        System.out.println(claims);
        return claims;
    }
}
