package com.atguigu.boot3.features.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    没有hahaha的属性就取默认值localhost
    @Value("${hahaha:localhost}")
    String hahaha;
    @GetMapping("/haha")
    public String getHah(){
        return hahaha;
    }
}
