package com.atguigu.springbootdemo4web.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@JacksonXmlRootElement  //可以写出格式为xml文档
public class Person {

    private String username;
    private String email;
    private String id;
    private Integer age;
    private String role;
    public Person() {
    }

    public Person(String username,String role, String email,Integer age, String id) {
        this.username = username;
        this.email = email;
        this.id = id;
        this.age = age;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
