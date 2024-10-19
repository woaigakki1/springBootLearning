package com.atguigu.springboot3demo7core.service;

import com.atguigu.springboot3demo7core.UserEntity.User;
import com.atguigu.springboot3demo7core.event.LoginSuccessEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SysService {
    public void recordLog(String username){
        System.out.println("logging:" + username);
    }
    @EventListener
    public void onEvent(LoginSuccessEvent applicationEvent){
        System.out.println("sysService == 收到事件了");
        User user = (User) applicationEvent.getSource();
        recordLog(user.getUsername());
    }
}
