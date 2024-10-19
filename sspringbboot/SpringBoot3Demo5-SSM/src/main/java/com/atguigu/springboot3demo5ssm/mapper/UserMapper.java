package com.atguigu.springboot3demo5ssm.mapper;

import com.atguigu.springboot3demo5ssm.bean.TUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

public interface UserMapper {
    /**
     * 1.每个参数都在mapper文件中有一个对应
     * 2.每个参数都应该用@Param进行签名 方便以后再xml中进行查询
     * @param id
     * @return
     */

    public TUser getUserById(@Param("id") Long id);
}
