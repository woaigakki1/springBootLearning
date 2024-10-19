package com.atguigu.boot3.starter.robot.controller;



import com.atguigu.boot3.starter.robot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
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
