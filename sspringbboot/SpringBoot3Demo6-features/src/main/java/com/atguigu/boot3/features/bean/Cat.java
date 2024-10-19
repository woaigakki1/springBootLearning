package com.atguigu.boot3.features.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
//@Profile({"dev"})
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Component
public class Cat {
    private String name;
    private String id;

}
