package com.atguigu.springboot3demo7core.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher  implements ApplicationEventPublisherAware {
    /**
     * 底层发送事件用的组件 springboot会通过ApplicationEventPublisherAware接口自动注入给我们
     * 事件是广播出去的 所有监听事件的监听器都能收到
     * 可以使用@Order注解来设置事件发生的顺序
     */
    static ApplicationEventPublisher applicationEventPublisher;

    /**
     * 发送所有的事件
     * @param event
     */
    public static void sendEvent(ApplicationEvent event){
//        调用api发送事件
        applicationEventPublisher.publishEvent(event);
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher =applicationEventPublisher;
    }
}
