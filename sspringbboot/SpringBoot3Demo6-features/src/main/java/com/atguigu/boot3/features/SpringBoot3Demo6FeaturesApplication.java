package com.atguigu.boot3.features;

import com.atguigu.boot3.features.bean.Cat;
import com.atguigu.boot3.features.bean.DingZhen;
import com.atguigu.boot3.features.bean.Dog;
import com.atguigu.boot3.features.bean.Sheep;
import com.atguigu.boot3.features.config.MyConfig;
import com.atguigu.boot3.starter.robot.RobotAutoConfiguration;
import com.atguigu.boot3.starter.robot.annotation.EnableRobot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 表示环境  区分出来几个环境 development 开发环境 test 测试环境 production 生产环境
 *          指定每个组件在那个环境下生效
 *          默认只有激活指定的环境 这些组件才会生效  默认是default环境  没有写@profile就是默认default
 * 那么怎么激活环境呢
 *          1.配置文件激活 spring.profiles.active = ?
 *          2.命令行激活 Java -jar xxx.jar --spring.profiles.active=prod?dev
 * 配置文件怎么使用profile功能
 *      1.) application.properties 永远生效
 *      其他profile 例如 application-dev.properties 命名规范为application-{profile}.properties
 *      例如设置一个server.port为10000 在dev环境下 但是另一个application-dev.properties中server.port=10001
 *      那么当application.properties中指定spring.profiles.active=dev 那么端口号为10001
 *      注意 spring.profiles.active这个属性只能写在无profile的文件中 例如在application-dev.properties中标注无效
 */
@EnableRobot
@SpringBootApplication
@Slf4j
public class SpringBoot3Demo6FeaturesApplication {


    public static void main(String[] args) {
//        api 的核心程序入口
//        SpringApplication.run(SpringBoot3Demo6FeaturesApplication.class, args);
//        分开两部写可以自定义一些行为在run之前
//        SpringApplication springApplication = new SpringApplication(SpringBoot3Demo6FeaturesApplication.class);
////                springApplication中有很多方法可以自定义
////        这里的配置是比application.properties的优先级低的 但是是有用的
//                springApplication.setBannerMode(Banner.Mode.CONSOLE);
//        //      run
//        springApplication.run(args);


//        FluentBuilder 流式写法 创建springApplication
        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .main(SpringBoot3Demo6FeaturesApplication.class)
                .sources(SpringBoot3Demo6FeaturesApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .properties("server.port=9999") //spring的所有配置都可以在这里配置
//                .environment(null)
//                .listeners(null)
                .run(args);

        try {
            Cat cat = context.getBean(Cat.class);
            log.info("cat:{}",cat);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        try {
            Dog dog = context.getBean(Dog.class);
            log.info("dog:{}",dog);
        }catch (Exception e){
//            throw new RuntimeException("No"+e.getMessage());
        }
        try {
            DingZhen dingZhen = context.getBean(DingZhen.class);
            log.info("dingzhen:{}",dingZhen);
        }catch (Exception e){
//            throw new RuntimeException("No"+e.getMessage());
        }
        try {
            Sheep sheep = context.getBean(Sheep.class);
            log.info("sheep:{}",sheep);
        }catch (Exception e){
//            throw new RuntimeException("No"+e.getMessage());
        }

    }
}
