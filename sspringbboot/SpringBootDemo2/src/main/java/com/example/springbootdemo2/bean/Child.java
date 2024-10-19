package com.example.springbootdemo2.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class Child {
    private String name;
    private Integer age;
    private Date birthDay;
    private List<String> text;
}
