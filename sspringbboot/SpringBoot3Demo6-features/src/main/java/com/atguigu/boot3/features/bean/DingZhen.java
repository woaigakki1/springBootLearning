package com.atguigu.boot3.features.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Profile("prod")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class DingZhen {
    private String location;
    private String Star;
}
