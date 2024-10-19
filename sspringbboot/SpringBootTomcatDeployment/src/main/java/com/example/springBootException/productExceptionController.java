package com.example.springBootException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class productExceptionController {
    @ExceptionHandler(value = productNotFoundException.class)
    public ResponseEntity<Object> exception(productNotFoundException exception){
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}
