package com.atguigu.springbootdemo4web.biz;

import com.atguigu.springbootdemo4web.bean.Person;
import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@Slf4j
//专门处理有关user的业务
@Component
public class UserBizHandler {
//    其实是代替get请求的第三个参数HandlerFunction
//    查询指定id的用户
    public ServerResponse getUser(ServerRequest request) throws Exception {
//        业务处理 查询
//        简单的能让浏览器识别到几号用户
        String id = request.pathVariable("id");
        log.info("查询【{}】用户信息 数据库正在检索",id);
        Person person = new Person("lhl", "coder", "lhlssmile@gmail.com", 15, "15");
        return ServerResponse.ok().body(person);
    }
//     获取到所有的user
    public ServerResponse getAllUsers(ServerRequest request)throws Exception {
//        假设为一个list
        List<Person> personList = Arrays.asList(
                new Person("lhl1", "coder1", "l1", 1, "1"),
                new Person("lhl2", "coder2", "l2", 2, "2"),
                new Person("lhl3", "coder3", "l3", 3, "3"),
                new Person("lhl4", "coder4", "l4", 4, "4"),
                new Person("lhl5", "coder5", "l5", 5, "5")
        );
        return ServerResponse.ok().body(personList);
    }

    public ServerResponse saveUser(ServerRequest request) throws Exception {
//        保存person的信息成功了 意思是把请求体的数据封装json返回
        Person body = request.body(Person.class);
        log.info("保存用户信息成功了 {}",body.toString());
        return ServerResponse.ok().build();
    }

    public ServerResponse updateUser(ServerRequest request) throws ServletException, IOException {
        Person body = request.body(Person.class);
        log.info("update person successfully:{}",body);
        return ServerResponse.ok().build();
    }


    public ServerResponse deleteUser(ServerRequest request) {
        String id = request.pathVariable("id");
        log.info("delete person successfully : {}",id);
        return ServerResponse.ok().build();
    }
}
