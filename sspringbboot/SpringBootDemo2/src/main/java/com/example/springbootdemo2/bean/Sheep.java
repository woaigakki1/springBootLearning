package com.example.springbootdemo2.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
//声明是一个组件才能只用@ConfigurationProperties注解 用到@EnableConfigurationProperties
@ConfigurationProperties(prefix = "sheep")
public class Sheep {
    private String name;
    private Integer age;
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
