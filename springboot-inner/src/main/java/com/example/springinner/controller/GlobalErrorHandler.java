package com.example.springinner.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalErrorHandler {

    //不管是exception还是error，最后都是通过exception处理
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return "exception occurred";
    }

    @ResponseBody
    @ExceptionHandler(Error.class)
    public String handleError(Error e) {
        return "error occurred";
    }
//
//     @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public Long handleLong(Exception e) {
//        return -1L;
//    }
}
