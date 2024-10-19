package com.atguigu.boot3.features;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.EmptyStackException;
import java.util.Stack;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HelloTest {
    Stack<Object> stack;
    @Test
    @DisplayName("is instantiated with new stack()")
    void isInstantiatedWithNew(){
        new Stack<>();
    }
    @Nested               //嵌入测试
    @DisplayName("when new")
    class WhenNew{
        @BeforeEach
        void createNewStack(){
            stack = new Stack<>();
        }
        @Test
        @DisplayName("is empty")
        void isEmpty(){
            assertTrue(stack.isEmpty());
        }
        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped(){
            assertThrows(EmptyStackException.class,stack::pop);
        }
        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwExceptionWhenPeeked(){
            assertThrows(EmptyStackException.class,stack::peek);
        }
        @Nested
        @DisplayName("after pushing a element")
        class AfterPushing{
            String anElement = "an element";
            @BeforeEach
            void pushElement(){
                stack.push(anElement);
            }
            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty(){
                assertFalse(stack.isEmpty());
            }
            @Test
            @DisplayName("return the element when popped and is empty")
            void returnElementWhenPopped(){
                assertEquals(anElement,stack.pop());
                assertTrue(stack.isEmpty());
            }
            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked(){
                assertEquals(anElement,stack.peek());
                assertFalse(stack.isEmpty());
            }
        }
    }
}
