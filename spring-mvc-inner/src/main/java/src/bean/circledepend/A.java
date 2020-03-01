package src.bean.circledepend;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class A {
    /**
     *
     */
    @PostConstruct
    public void init() {
        System.out.println("-----------A init---------");
    }

    public void init2() {
        System.out.println("-----------A init2---------");
    }
}
