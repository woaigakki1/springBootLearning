package com.atguigu.springboot3demo7core.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * Springboot生命周期监听
 *  Listener 首先要从 META-INF/spring.factories
 *  1.引导  利用bootstrapContext引导整个项目启动
 *  starting  应用开始 springApplication的run方法一调用 只要有了bootStrapContext就执行
 *  environment 环境准备好 把启动参数等绑定环境变量 但是ioc还没有创建
 *  2.启动
 *      contextPrepared ioc容器创建并准备好  但是source 主配置类没有加载 并关闭引导上下文 组件都没创建
 *      contextLoaded ioc容器创建 主配置类加载进去了 但是ioc容器没有刷新 我们的bean还没有创建
 *      started ioc容器刷新了 所有的bean创建好了 但是runner没有调用
 *      ready ioc容器刷新了 所有的bean准备好了 runner调用了
 *      3.运行
 *       以上步骤都正确则运行
 */
public class MyAppListener implements SpringApplicationRunListener {
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("starting..");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("environment..");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("Prepare context ioc容器准备 准备上下文...");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("load context   加载上下文..");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("started 启动成功...");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("ready  就绪..");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("failed?");
    }
}
