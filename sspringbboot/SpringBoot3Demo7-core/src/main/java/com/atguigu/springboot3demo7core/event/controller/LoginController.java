package com.atguigu.springboot3demo7core.event.controller;

import com.atguigu.springboot3demo7core.UserEntity.User;
import com.atguigu.springboot3demo7core.event.EventPublisher;
import com.atguigu.springboot3demo7core.event.LoginSuccessEvent;
import com.atguigu.springboot3demo7core.service.AccountService;
import com.atguigu.springboot3demo7core.service.CouponService;
import com.atguigu.springboot3demo7core.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    AccountService accountService;
    @Autowired
    CouponService couponService;
    @Autowired
    SysService sysService;
    @GetMapping("/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password){
        //TODO  新写法
        /**
         * 创建一个发布事件的类 还有一个监听事件的类
         */

        EventPublisher.sendEvent(new LoginSuccessEvent(new User(username, password)));
        return "login success"+username;


        //        登录成功后自动签到 自动的优惠券等操作。
        /**
         * 以下为传统写法 耦合度较高
         */
//        accountService.addAccountScore(username);
//        couponService.sendCoupon(username);
//        sysService.recordLog(username);
    }
}
