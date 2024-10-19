package com.example.springbootdemo2.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


//@ConfigurationProperties(prefix = "pig")

public class Pig {
    private String name;
    private Long id;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "pig{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}


/**
 * 属性绑定
 * @ConfigurationProperties
 * @EnableConfigurationProperties
 * 将容器中任意组件Bean的属性值和配置文件的配置项的值进行绑定
 *   步骤是：1 给容器注册组件 @Component @Bean等等。。。
 *         2 使用@ConfigurationProperties声明组件和配置文件的哪些配置项进行配置进行绑定
 */