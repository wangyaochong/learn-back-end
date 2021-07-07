package com.example.springinner.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalErrorHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String handleString(Exception e) {
        return "error occurred";
    }
//
//     @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public Long handleLong(Exception e) {
//        return -1L;
//    }
}
