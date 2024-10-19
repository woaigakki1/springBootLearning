package com.example.springbootdemo3.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/hello")
    public String getHello(String a,String b){
//        打印日志
        logger.info("hahaha method invoked");
        log.info("hahaha method invoked react twice");
        //log的各种界别
        log.trace("trace log");
        log.debug("debug log");
        log.info("info log.... 字符串a:{},b:{}",a,b);
        log.warn("warn log");
        log.warn("error log");
        return "Hello springboot3";
        
    }
}
