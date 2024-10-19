package com.atguigu.springboot3demo7core.robot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//报红是因为需要配置文件 配置后前缀为robot的 属性也会有提示在写application.properties时
@Data
@Component
@ConfigurationProperties(prefix = "robot")
public class RobotProperties {
    private String name;
    private String email;
    private Integer age;
}
