package src.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import src.bean.Person;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("test")
public class TestController {

    @PostConstruct
    public void init(){
        System.out.println("controller 初始化");
        System.out.println(person);
    }
    @Resource
    Person person;

    @RequestMapping("test")
    @ResponseBody
    public Person test() {
        return person;
    }

    @RequestMapping("ser")
    @ResponseBody
    public String testSerialize() throws InterruptedException {
        System.out.println("-----testSerialize------------");
        TimeUnit.SECONDS.sleep(5);
        return "finied";
    }
}
