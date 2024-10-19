package com.example.springboottomcatdeployment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot应用程序属性
 * 命令行属性
 * Spring Boot 应用程序将命令行属性转换为 Spring Boot 环境属性。
 * 命令行属性优先于其他属性源。 默认情况下，Spring Boot 使用 8080 端口号来启动 Tomcat。 让我们学习如何使用命令行属性更改端口号。
 *步骤 1 − 创建可执行 JAR 文件后，使用命令 java –jar <JARFILE> 运行它。
 *步骤 2 − 使用下面给出的屏幕截图中给出的命令，通过命令行属性更改 Spring Boot 应用程序的端口号。
 * Command Line Properties JARFILE
 * 注意 − 您可以使用分隔符提供多个应用程序属性 −
 * 属性文件用于将"N"个属性保存在单个文件中，以在不同的环境中运行应用程序。 在 Spring Boot 中，属性保存在类路径下的 application.properties 文件中。
 * application.properties 文件位于 src/main/resources 目录中。
 */
@SpringBootApplication
@RestController
public class SpringBootAppAttributeTest1 {
    @Value("${spring.application.name}")
    private String name;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppAttributeTest1.class);
    }
//    http://localhost:9090/testa  会输出spring.application.name的键对应的值

    /**
     *注意 − 如果在运行应用程序时未找到该属性，则 Spring Boot 将 Illegal Argument
     * 异常作为 Could not resolve placeholder 'spring.application.name' in value "${spring.application.name}" 抛出。
     * 要解决占位符问题，我们可以使用下面给出的语法设置属性的默认值 −
     * @Value("${property_key_name:default_value}")
     * @Value("${spring.application.name:demoservice}")
     */
    @RequestMapping("/testa")
    public String getNameaa(){
        return name;
    }
}
