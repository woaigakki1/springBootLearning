package com.atguigu.springbootdemo4web.controller;

import com.atguigu.springbootdemo4web.bean.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
public class HelloController {
//    *代表多个或者0哥字符 ？ 一个字符[] 限定字符范围a-f +可以有多个 {} 里边叫做一个路径变量 名称为p1

    /**
     * 默认使用新版的PathPatternParser 进行路径匹配
     * 效率高性能强 但是缺点是 使用/** 时候只能放在末尾处
     * @param request
     * @param path
     * @return
     */
    @GetMapping("/a*/b?/{p1:[a-f]+}/**")
    public String hello(HttpServletRequest request, @PathVariable("p1") String path){
        log.info("wocenimenma"+path);
        String uri = request.getRequestURI();
        return uri;
    }
    @GetMapping("/person")
    public Person newPerson(){
        Person person = new Person();
        person.setEmail("lhlssmile@gmail.com");
        person.setId("lov kanye west");
        person.setUsername("lhl");
        return person;
        /**
         * springboot默认支持把对象写成json格式 默认web导入了jackson处理json的包
         * jackson是一个库 也支持把数据写成xml 但是要导入xml相关的依赖
         * 内容协商
         * 请求同一个接口 返回的内容形式不同
         * 例如 可能访问一个url想要的结果是json 或者是 xml
         * 这时候就需要用到内容协商
         */
    }
//获取到国际化的消息
    @Autowired
    MessageSource messageSource;
    @GetMapping("/haha")
    public String setInternationalMessages1(HttpServletRequest request){
//        利用代码的方式获取配置文件中的指定配置项的信息
        Locale locale = request.getLocale();
        String login = messageSource.getMessage("login", null, locale);
//        int i=10/0;
        return login;
    }



//    public static void main(String[] args) throws JsonProcessingException {
//        Person person = new Person("llhl", "lhlsssmile@gmail.com", "SZA");
//        YAMLFactory yamlFactory = new YAMLFactory();
////        开头的三个 --- 去掉了
//        YAMLFactory disable = yamlFactory.disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
//        ObjectMapper objectMapper = new ObjectMapper(yamlFactory);
////        输出为yml格式
//        System.out.println(objectMapper.writeValueAsString(person));
//    }
}
/**
 * ant风格路径用法
 * * 表示任何数量的字符
 * ? 表示任意地一个字符
 * ** 表示任意数量的目录
 * {} 表示一个命名的模式占位符
 * [] 表示字符集合,例如[a-z]表示所有的小写字母
 *  如果需要转义字符 例如转移 * 用\\*
 * some exs
 * *.html -> 表示匹配任意名称 扩展名为html的文件
 * /folder1/ * / *.java -> 表示匹配在folder1两级目录下的任意名称Java文件
 * /folder2/ ** .jsp -> 表示匹配到folder2文件下任意深度的jsp文件
 * /{type}/{id}.html -> 表示匹配任意文件名{id}.html 在任意名的{type}目录下的文件
 */