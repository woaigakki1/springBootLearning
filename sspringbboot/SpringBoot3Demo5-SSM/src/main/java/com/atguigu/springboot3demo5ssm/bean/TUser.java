package com.atguigu.springboot3demo5ssm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TUser {
    private Long id;
    private String loginName;
    private String nickName;
    private String passwd;
}
