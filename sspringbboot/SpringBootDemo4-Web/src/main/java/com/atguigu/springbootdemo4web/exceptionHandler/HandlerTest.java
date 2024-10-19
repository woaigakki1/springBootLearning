package com.atguigu.springbootdemo4web.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice   //统一处理所有的错误
public class HandlerTest {
    @ResponseBody
//    @ExceptionHandler  //默认只能处理一个类发生的错误
    public String handlerException(Exception e){
        return "failed No reason"+e.getMessage();
    }
}

/**
 * 业务发生错误时候 先会用spring MVC的错误处理机制 用@ExceptionHandler注解机制看是否能处理没有就继续找@ResponseStatus注解处理
 * 如果还是不能处理就调用SPringMVC定义的默认错误相应处理
 * 都不能处理就会交给Springboot进行处理
 * 发生错误之后 转发给/error路径 Springboot在底层写一个BasicErrorController组件 专门处理这个请求
 * 既可以返回json 也可以返回html  即内容协商请求
 * 错误页面是怎么解析到的呢?
 * 首先是解析错误的视图地址 如果找不到错误的页面地址 默认错误的页面就是error
 * 解析一个错误页
 * 如果发生了一个
 *      500 400 4xx 5xx的错误
 *      如果有模板引擎 默认在 /templates/精确码.html找 若果找不到就在整个静态资源下找 如果找不到精确码的页面就找模糊码
 *      例如 4xx.html 5xx.html
 *
 *      最佳实战
 *      在templates下创建一个error文件夹。里边是专门处理错误的
 *      前后端分离处理错误。
 *      @ExceptionHandler+@ControllerAdvice处理
 *      classpath:/templates/error 下放至精确的错误页面  例如500.html,404.html 为精确的错误页面  （状态码错误）
 *      模糊页面有4xx.html 5xx.html 通用错误页面有error.html           （业务错误）
 *
 */