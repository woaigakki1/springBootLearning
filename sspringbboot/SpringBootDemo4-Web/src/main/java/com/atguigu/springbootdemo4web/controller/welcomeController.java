package com.atguigu.springbootdemo4web.controller;

import com.atguigu.springbootdemo4web.bean.Person;
import com.atguigu.springbootdemo4web.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller   // 适配 服务端渲染
public class welcomeController {

    @Autowired
    AService aService;
    public void testGetContextPathAnyWhere(){
        aService.a();
    }
    /**
     * 模板引擎跳转到指定页面
     * @return
     */
    @GetMapping("/welcome")
    public String getWelcome(@RequestParam("name")String name, Model model){
//        默认在templates下找html文件 相当于写页面名称
//        模板的逻辑视图地址
//        物理视图 =前缀+ 逻辑视图名 + 后缀
//        真实地址   classpath:/templates/welcome.html
//        吧需要给页面共享的数据放到model中
        String text = "<span style='color:red'>"+name+"</span>";
        model.addAttribute("name",text);
//        传进去一个图片 路径是动态的
        model.addAttribute("toUpperCaseTest",name);
            model.addAttribute("imgUrl","3.jpg");
//        假设样式是从数据库查出来的
        model.addAttribute("styleSettings","height:600px");
//        设置条件
        model.addAttribute("whetherShow",true);
        return "welcome";
    }
    @GetMapping("/")
    public String WelcometoIndex(){
        return "index";
    }
    @GetMapping("/list")
    public String getList(Model model){
        List<Person> people = Arrays.asList(
                new Person("lhl1", "pm","lhlssmile@gmail.com1", 15, "1"),
                new Person("lhl2","hr" ,"lhlssmile@gmail.com2", 22,"2"),
                new Person("lhl3","admin" ,"lhlssmile@gmail.com3",21, "3"),
                new Person("lhl4", "hr","",21, "4")
        );
        model.addAttribute("persons",people);
        return "list";
    }
    @GetMapping("/testGetStaticPicture")
    public String getStaticPicture(Model model){
        model.addAttribute("imgTest","staticPicture.jpg");
        return "getPicture";
    }
}
