package com.atguigu.springbootdemo4web.config;

import com.atguigu.springbootdemo4web.component.MyYamlHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.TimeUnit;

//@Configuration
public class myConfigMethod2 {
//    这是第二种写法
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            保留之前的设置
                WebMvcConfigurer.super.addResourceHandlers(registry);
//            自己添加设置
                registry.addResourceHandler("/**").addResourceLocations("classpath:/b")
                        .setCacheControl(CacheControl.maxAge(2000, TimeUnit.SECONDS));
            }
// 配置一个拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
            }

            @Override   //配置一个能返回yaml的消息返回器
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new MyYamlHttpMessageConverter());
            }
        };
    }
}
