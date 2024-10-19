package com.atguigu.springboot3demo7core.service;

import com.atguigu.springboot3demo7core.UserEntity.User;
import com.atguigu.springboot3demo7core.event.LoginSuccessEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    public void sendCoupon(String username){
        System.out.println(username + "get a coupon");
    }
//    @Async   //睡多久主程序都不会卡死
    @Order(1)
    @EventListener
    public void onEvent(LoginSuccessEvent event){
        System.out.println("Coupon === 收到事件了");
        User user = (User) event.getSource();
        sendCoupon(user.getUsername());
    }
}
