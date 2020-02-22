package src.bean.circleDepend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class A {
    @Autowired
    B b;

    //    @Autowired
//    BeanTest beanTest;
    @PostConstruct
    public void init() {
        System.out.println("-----------A init---------");
    }

    public void init2() {
        System.out.println("-----------A init2---------");
    }
}
