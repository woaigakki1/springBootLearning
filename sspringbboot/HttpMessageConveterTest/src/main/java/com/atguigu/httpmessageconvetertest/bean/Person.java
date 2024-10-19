package com.atguigu.httpmessageconvetertest.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement  //可以写出xml文档
public class Person {
    private String username;
    private String password;
}
