package com.atguigu.springboot3demo7core.robot.controller;


import com.atguigu.springboot3demo7core.robot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {
    @Autowired
    RobotService robotService;
    @RequestMapping("/test/robot")
    public String getRobot(){
        return robotService.sayHello();
    }

}
