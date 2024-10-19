package com.example.springBootException;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class productNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
}
