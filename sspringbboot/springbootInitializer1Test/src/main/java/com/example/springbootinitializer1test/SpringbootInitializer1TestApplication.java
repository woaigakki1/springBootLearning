package com.example.springbootinitializer1test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootInitializer1TestApplication {
    @RequestMapping("/")
    public String GetName(){
        return "wocenimenma";
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SpringbootInitializer1TestApplication.class, args);
        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
/**
 * 默认的扫描规则
 * @SpringBootApplication标注的类就是主程序类
 * 可以自定义类的扫描路径
 * @SpringBootApplication(scanBasePackages = "path") 可以自定义扫描的路径
 * 或者是写注解@ComponentScan("path")来指定扫描的路径
 * 配置文件的所有配置项和某个类的对象值一一进行绑定的
 * 绑定了配置文件中每一项值的类 属性类
 * 例如application.properties类中的属性名称对应值都是在类中可找到
 *
 */