package com.atguigu.boot3.features.config;

import com.atguigu.boot3.features.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile("test")
@Configuration
@PropertySource("classpath:aaa.properties")
public class MyConfig {
    @Profile("dev")
    @Bean
    public Cat getCat(){
        return new Cat();
    }
}
/**
 * 配置 命令行>配置文件>默认属性
 * 命令行参数写法   --attribute->value
 * 配置可以写到很多位置
 * 打包jar后仍然可以创建一个application.properties文件 且优先级高于打jar包前
 * 同级情况下 application.properties < application-dev.properties
 * 包内包外都有application.properties和application-dev.properties
 * 优先级为 9001>8001>9000>8000 如果在cmd写参数那么
 *                  cmd>9001>8001>9000>8000
 *                  在config中配置application.properties和application-dev.properties
 *                  那么config包下application-dev.properties>优先级高于根路径下，但是永远小于cmd
 *                  如果包外也有一个config包 那么也是高于根目录下
 *                  config里还有子目录，那么优先级会更高
 */