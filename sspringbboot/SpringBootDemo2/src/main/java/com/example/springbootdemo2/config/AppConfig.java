package com.example.springbootdemo2.config;


import com.example.springbootdemo2.bean.Cat;
import com.example.springbootdemo2.bean.Pig;
import com.example.springbootdemo2.bean.Sheep;
import com.example.springbootdemo2.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
//@Import("第三方包名") 给容器中放指定类型的组件 默认为全类名
//这是一个配置类  替代xml
@Configuration
@EnableConfigurationProperties(Sheep.class)  //一般用于第三方组件的导入
//第三方包放到@Component上也是无效的 springboot只会扫描自己的包
public class AppConfig {
    @Scope("prototype")
    @Bean("user11")
    public User user(){
        User user = new User();
        user.setId(1L);
        user.setName("丁真");
        return user;
    }
    /*替代以前的bean标签  名字默认就是方法名  也可以在Bean注解后括号里指定名字
    * 单例的重复获取名字相同 想要成为多例设置属性scope为prototype
    *  */
    @Bean
    public Cat cat(){
        Cat tom = new Cat(1L, "Tom");
        return tom;
    }
    @ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
    @Bean(name = "cat1")
    public Cat cat1(){
        return new Cat(2L,"www");
    }
//  如果类路径中不存在这个类 则会触发指定行为
    @ConditionalOnMissingClass(value = "com.alibaba.druid.FastsqlException")
    @Bean(name = "user22")
    public User user22(){
        return new User(2L,"wwwad");
    }
//    如果类路径中存在这个Bean组件则会触发对应的行为
    @ConditionalOnBean(value = User.class)
    @Bean(name = "user213")
    public User user213(){
        return new User(2L,"wwwadad");
    }
    @Bean
    @ConfigurationProperties(prefix = "pig")
    public Pig pig(){
       return new Pig();
    }
}
