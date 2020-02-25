package src.designPattern.dynamicRroxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(User.class);
        enhancer.setCallback(new UserMethodInterceptor());
        User o = (User) enhancer.create();
        o.userMethod();
    }
}
