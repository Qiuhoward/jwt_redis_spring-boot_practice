package com.example.redis.utils;

import org.springframework.data.redis.core.RedisTemplate;

public class RedisUtils {


    //回家寫工具包 順便寫EvnetMessage
    private final RedisTemplate<String,String> redisTemplate;

    public RedisUtils(RedisTemplate redisTemplate) {

        this.redisTemplate = redisTemplate;
    }





}
