package src.myaop;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyAopBean implements MyAopInterface {

    @PostConstruct
    public void init() {//这个init方法不会被调用，因为生成了一个代理类了
        System.out.println("---------my aop bean init");
    }

    @Override
    public void method() {
        System.out.println("MyAopBean method called");
    }
}
