package com.example.springbootdemo2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Component
@ConfigurationProperties(prefix = "person")
@Data  //自动生成javabean的getter 和 setter
@NoArgsConstructor  //无参构造器
@AllArgsConstructor //全参数构造方法
public class Person {
    private String name;
    private Integer age;
    private Date birthDay;
    private Boolean like;
    private Child child; // yml嵌套对象
    private List<Dog> dogs; //yml表示数组
    private Map<String,Cat1> cats; //yml表示map

}
