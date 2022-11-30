package com.example.redis.controller;


import com.example.redis.bean.AddDto;
import com.example.redis.service.RedisService;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @PostMapping(value = "/add")
    public Claims add(@RequestBody AddDto addDto){
        return redisService.add(addDto);
    }


}
