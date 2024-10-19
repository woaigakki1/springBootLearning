package com.atguigu.boot3.features;

import com.atguigu.boot3.features.service.HelloService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest  //可以测试springboot中所有的组件
class SpringBoot3Demo6FeaturesApplicationTests {
    @Autowired
    HelloService helloService;
    @DisplayName("测试1")
    @Test
    void contextLoads() {
        int sum = helloService.Sum(2, 3);
        Assertions.assertEquals(5,sum);
        System.out.println(sum);
    }
    @DisplayName("😮")  // 左侧显示的测试方法名字
    @Test
    void test1(){
        System.out.println("aaaa");
    }
//    所有方法运行前先运行这个 纸打印一次
    @BeforeAll
    static void initAll(){
        System.out.println("hello");
    }
//    每个方法运行前运行这个 每个方法都会打印一次
    @BeforeEach
    void init(){
        System.out.println("world");
    }
    @ParameterizedTest
    @ValueSource(strings = {"one", "two","three"})
    @DisplayName("参数化测试")
    public void ParameterizedTest(String string){
        System.out.println(string);
        Assertions.assertTrue(StringUtils.isNotBlank(string));
    }

    @ParameterizedTest
    @MethodSource("method")    //指定的方法名 name取值为里边的两个
    @DisplayName("方法来源参数")
    public void testWithExplicitLocalMethodSource(String name){
        System.out.println(name);
        Assertions.assertNotNull(name);
    }
    static Stream<String> method(){
        return Stream.of("apple","banana");
    }
}
