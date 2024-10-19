package com.atguigu.springboot3demo7core;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableAsync   // 开启异步操作
//@EnableScheduling   开启定时任务
@SpringBootApplication
public class SpringBoot3Demo7CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3Demo7CoreApplication.class, args);
    }
    @Bean
    public ApplicationRunner applicationRunner(){
        return args -> {
            System.out.println("可以做一些干预在准备就绪ready之前 - ApplicationRunner"+args);
        };
    }
    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("可以做一些干预在准备就绪ready之前 - commandLineRunner"+args);
        };
    }
}
