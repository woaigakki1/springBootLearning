package com.atguigu.springboot3demo7core.event;

import com.atguigu.springboot3demo7core.UserEntity.User;
import org.springframework.context.ApplicationEvent;

/**
 * 登陆成功事件
 * 这是一个事件 要被发出去的
 */
public class LoginSuccessEvent extends ApplicationEvent {
//    发送的事件可以把对象传进去
    public LoginSuccessEvent(User user) {
        super(user);
    }
}
