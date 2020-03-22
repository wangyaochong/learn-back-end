package src.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BeanTest {
    public BeanTest() {
        System.out.println("BeanTest显示初始化");
    }

    @PostConstruct
    public void init() {
        System.out.println("beanTest init 测试");
    }
}
