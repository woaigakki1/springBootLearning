package com.atguigu.springbootdemo4web.config;

import com.atguigu.springbootdemo4web.bean.Person;
import com.atguigu.springbootdemo4web.biz.UserBizHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * 函数式web
 * 给容器中放一个bean 类型是RouterFunction<ServerResponse>
 *     每个业务准备一个自己的handler
 *  核心四大对象
 *  RouterFunction 定义路由信息 发什么请求 谁来处理
 *  RequestPredicate 定义请求 请求谓语 请求方式 get post 请求参数
 *  ServerRequest 封装请求完整数据
 *  ServerResponse 封装相应完整数据
 */

@Configuration
public class WebFunctionConfig {
//    这个userRoute方法的参数是一个对象 默认会从组件中拿 相当于@Autowired自动注入了 userBizHandler
    @Bean
    public RouterFunction<ServerResponse> userRoute(UserBizHandler userBizHandler){
//        定义一个路由信息
      return   RouterFunctions.route()
//                HandlerFunction换成自己写的
                .GET("/user/{id}", RequestPredicates.accept(MediaType.ALL),userBizHandler::getUser)
                .GET("/users",userBizHandler::getAllUsers)
                .POST("/user",RequestPredicates.accept(MediaType.APPLICATION_JSON),userBizHandler::saveUser)
                .PUT("/user/{id}", RequestPredicates.accept(MediaType.APPLICATION_JSON),userBizHandler::updateUser)
                .DELETE("/user/{id}",userBizHandler::deleteUser)
                .build();
    }
}
