package com.example.redis.controller;

import com.example.redis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("redis")
public class UserController {

   //宣告RedisTemplate記得加類型如<key:string1,value:string2>
    private final RedisTemplate<String, String> redisTemplate;


    public UserController(RedisTemplate<String, String> redisTemplate) {

        this.redisTemplate = redisTemplate;
    }



    @PostMapping("add")
    public String add(@RequestBody User user) {
        log.info("開始新增");
        redisTemplate.opsForValue().set(String.valueOf(user.getId()),user.toString());
        return "新增成功";
    }
    @GetMapping("get")
    public Object get(@RequestParam(value = "id")long id){
        log.info("進行查詢");
        return redisTemplate.opsForValue().get(String.valueOf(id));
    }

    @PutMapping("edit")
    public  String edit(@RequestBody User user,@RequestParam(value = "id")long id){
        log.info("編輯");
        redisTemplate.opsForValue().set(String.valueOf(id),user.toString());
        return "修改成功";
    }

    @DeleteMapping("delete")

    public  String delete(@RequestParam(value = "id")long id){
        log.info("刪除指定id");
        redisTemplate.delete(String.valueOf(id));
        return "刪除成功";

    }
}
