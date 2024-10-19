package com.example.springbootinitializer1test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
public class HelloWorldTest {
        @RequestMapping("/hello")
       public String  getvalue(){
            System.out.println("哈哈哈哈");

            return  "Hello World";
    }

}
