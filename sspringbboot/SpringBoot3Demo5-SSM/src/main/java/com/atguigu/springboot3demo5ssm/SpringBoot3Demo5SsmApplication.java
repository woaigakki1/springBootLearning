package com.atguigu.springboot3demo5ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 告诉mybatis 扫描哪个包下的所有接口
 */
@MapperScan(basePackages = "com.atguigu.springboot3demo5ssm.mapper")
@SpringBootApplication
public class SpringBoot3Demo5SsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3Demo5SsmApplication.class, args);
    }

}
