package com.yusuf.spring.web;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationException(MethodArgumentNotValidException exception){
       return exception.getFieldErrors()
                .stream()
                .map(err -> err.getDefaultMessage())
                .toList();
    }
}
