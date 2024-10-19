//package com.atguigu.springbootdemo4web.config;
//
//import com.atguigu.springbootdemo4web.service.AService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.CacheControl;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.sql.Time;
//import java.util.concurrent.TimeUnit;
////@EnableWebMvc  加上就会禁用boot的自动设置 所以手动和自动混合使用时候不用加
////手动和自动一起用
//@Configuration //这是一个配置类
//public class myConfig implements WebMvcConfigurer {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        保留以前的默认配置
//        WebMvcConfigurer.super.addResourceHandlers(registry);
////        自己写 请求/static/**
//        /**
//         * 例如 访问url为 localhost:8080/static/1.jpg
//         * springboot就会找到a文件下的1.jpg
//         */
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/a/","classpath:/b/")
//                .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
//    }
//}
///**
// * 为什么放一个WebMvcConfigure就能生效
// *
// */