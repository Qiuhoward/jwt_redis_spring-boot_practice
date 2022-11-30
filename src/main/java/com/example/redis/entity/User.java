package com.example.redis.entity;

import lombok.Data;
import java.io.Serializable;

@Data
//实体类实现序列化接口，否则无法存入redis数据库
public class User implements Serializable {

    private long id;
    private String name;
    private int age;
    private float height;
    private float weight;
}
