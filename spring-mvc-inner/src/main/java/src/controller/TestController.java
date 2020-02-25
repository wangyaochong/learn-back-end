package src.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import src.bean.Person;
import src.bean.TestBean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
public class TestController {

    @PostConstruct
    public void init(){
        System.out.println("controller 初始化");
        System.out.println(person);
    }
    @Resource
    Person person;

    @RequestMapping("/test")
    @ResponseBody
    public Person test() {
        return person;
    }
}
