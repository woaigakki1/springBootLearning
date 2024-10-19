package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuckWorld {
    @GetMapping("/fuck")
    public  String world() {
        System.out.println("fuck world");
            return "world";
    }
}
