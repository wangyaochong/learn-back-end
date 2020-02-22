package src.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OtherBean {
    @PostConstruct
    public void init() {
        System.out.println("init other OtherBean");
    }
}
