package com.wangyaochong.springsecurityboot;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author wangyaochong
 * @date 2020/3/24 09:27
 */
@ControllerAdvice
public class ControllerAdvisor {
//    有多种方法可以自定义403页面
//    @ExceptionHandler(AccessDeniedException.class)
//    public ModelAndView handle(Exception ex) {
//        ModelAndView mv = new ModelAndView();
//        if (UtilSecurity.getUserName() == null) {
//            mv.addObject("message", ex.getMessage());
//            mv.setViewName("login");
//        } else {
//            mv.addObject("message", ex.getMessage());
//            mv.setViewName("403");
//        }
//        return mv;
//    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handle(Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", ex.getMessage());
        mv.setViewName("404");
        return mv;
    }
}
