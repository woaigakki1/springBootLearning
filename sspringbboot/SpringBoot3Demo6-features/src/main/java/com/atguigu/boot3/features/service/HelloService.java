package com.atguigu.boot3.features.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public int Sum(int a, int b) {
        return a + b;
    }
}
