package com.atguigu.springboot3demo7core.service;

import com.atguigu.springboot3demo7core.UserEntity.User;
import com.atguigu.springboot3demo7core.event.LoginSuccessEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * 事件监听器
 */
@Service
public class AccountService implements ApplicationListener<LoginSuccessEvent> {
    public void addAccountScore(String username){
        System.out.println(username + "+1分");
    }

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        System.out.println("addService == 收到事件了");
        User user = (User) event.getSource();
        addAccountScore(user.getUsername());
    }
}
