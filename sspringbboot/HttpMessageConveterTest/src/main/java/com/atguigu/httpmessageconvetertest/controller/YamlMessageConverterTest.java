package com.atguigu.httpmessageconvetertest.controller;

import com.atguigu.httpmessageconvetertest.bean.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YamlMessageConverterTest {
    @GetMapping("/testMessageNegation")
    public Person getPerson() {
        Person person = new Person("丁真","1515");

        return person;
    }

}
