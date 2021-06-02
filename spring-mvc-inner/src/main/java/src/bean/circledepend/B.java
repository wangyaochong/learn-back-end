package src.bean.circledepend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class B {
    A a;

    @Autowired
    public void setA(A a){
        this.a = a;
    }
    @PostConstruct
    public void init() {
        System.out.println("-----------B init---------");
    }
}

