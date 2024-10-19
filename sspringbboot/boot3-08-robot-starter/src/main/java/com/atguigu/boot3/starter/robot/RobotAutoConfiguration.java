package com.atguigu.boot3.starter.robot;

import com.atguigu.boot3.starter.robot.controller.RobotController;
import com.atguigu.boot3.starter.robot.properties.RobotProperties;
import com.atguigu.boot3.starter.robot.service.RobotService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Springboot默认只会扫描自己的包 别人的是不会扫描的
 * 此处想要实现 Demo6的主程序能够扫描到robot-starter
 */
@Import({RobotController.class, RobotService.class, RobotProperties.class})
@Configuration
public class RobotAutoConfiguration {
}
