package com.learnspringboot.learnSubject.annotations.测试子类是否能继承父类时注解的行为;

import org.springframework.stereotype.Service;

@Service

/**
 @Service 注解不会被继承，方法上的注解会被继承，具体取决于spring对注解的内部实现方式，比如
 @RunWith(SpringRunner.class)
 @SpringBootTest 这两个注解对子类也是生效的
 */

public class ChildClass extends ParentClass {

    public ChildClass() {
        System.out.println("子类初始化了");
    }

//    public void init() {
//        System.out.println("子类的init方法");
//    }

    //注释掉init方法，会在有@service注解的情况下，会调用父类方法，取消注释，则调用子类自身的实现
    //如果取消@service方法，该子类不会被spring初始化成bean对象
}
