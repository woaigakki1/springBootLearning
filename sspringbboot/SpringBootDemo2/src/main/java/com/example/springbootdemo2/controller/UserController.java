package com.example.springbootdemo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    StringRedisTemplate redisTemplate;
    @RequestMapping("/")
    public String getName(){
        return "hello springboot3";
    }
//    @RequestMapping("/incr")
//    public String incr(){
//        Long dingzhen = redisTemplate.opsForValue().increment("dingzhen");
//        return "houlaide:"+dingzhen;
//    }
}
