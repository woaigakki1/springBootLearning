package com.example.springbootdemo2;

import com.example.springbootdemo2.bean.Person;
import com.example.springbootdemo2.bean.Pig;
import com.example.springbootdemo2.bean.Sheep;
import com.example.springbootdemo2.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ComponentScan("com.example.springbootdemo2")
@EnableAutoConfiguration
@Configuration
//@SpringBootApplication
public class SpringBootDemo2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootDemo2Application.class, args);
//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//        Object user1 = run.getBean("user11");
//        Object user2 = run.getBean("user11");
//        System.out.println(user1 == user2);
        for (String s : run.getBeanNamesForType(User.class)) {
            System.out.println(s);
        }
        Pig pig = run.getBean(Pig.class);
        System.out.println("pig" + pig);
        Sheep sh = run.getBean(Sheep.class);
        System.out.println("sh" + sh);
        Person person = run.getBean(Person.class);
        System.out.println("person"+person);
        System.out.println("================================");
        List<String> text = person.getChild().getText();
        System.out.println("用|会保留格式 用>会压缩文本");
        for (String s : text) {
            System.out.println(s);
        }
        System.out.println("测试压缩文本");
        String s = person.getChild().getText().get(4);
        System.out.println(s);
    }
}
