package com.example.springboottomcatdeployment;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplicationRunnerTest implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("hello world from application runner");
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationRunnerTest.class);
    }
}
/**
 * applicationRunner是一个接口 用于在SpringBoot应用执行后执行代码
 */