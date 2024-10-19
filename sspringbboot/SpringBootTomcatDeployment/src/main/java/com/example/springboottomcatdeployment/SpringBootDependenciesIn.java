package com.example.springboottomcatdeployment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class SpringBootDependenciesIn {
    @Autowired
    static
    RestTemplate restTemplate;
    @Autowired
    static Map<String,User> map = new HashMap<>();
    @Autowired
    static User user=new User("dingzhen","123456");
//  SpringBoot依赖注入
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDependenciesIn.class);
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        System.out.println("普通类"+user);
        System.out.println(user.getPassword()+":"+user.getUsername());
        map.put("user1", user);
        Set<Map.Entry<String, User>> entries = map.entrySet();
        Iterator<Map.Entry<String, User>> iterator = entries.iterator();
        if (iterator.hasNext()) {
            Map.Entry<String, User> entry = iterator.next();
            String StringValue = entry.getKey();
            User userObject = entry.getValue();
            System.out.println(StringValue + ":" + userObject.getUsername() + "-" + userObject.getPassword());
        }
    }
}

