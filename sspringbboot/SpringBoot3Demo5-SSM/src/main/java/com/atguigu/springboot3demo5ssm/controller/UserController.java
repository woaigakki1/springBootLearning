package com.atguigu.springboot3demo5ssm.controller;

import com.atguigu.springboot3demo5ssm.bean.TUser;
import com.atguigu.springboot3demo5ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用restController
 */
@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    /**
     * 返回对象会以json格式写出去
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public TUser getTUserById(@PathVariable("id") Long id) {
        TUser user = userMapper.getUserById(id);
        return user;
    }
}
