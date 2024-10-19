package com.atguigu.springbootdemo4web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SpringBootApplication
public class SpringBootDemo4WebApplication extends ResponseEntityExceptionHandler {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo4WebApplication.class, args);
    }

}
