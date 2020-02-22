package src.myaop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if (bean instanceof MyAopInterface) {
//            return Proxy.newProxyInstance(MyAopClassInvocationHandler.class.getClassLoader(), new Class[]{MyAopInterface.class}, new MyAopClassInvocationHandler(bean));
//        }
//        return bean;
//    }

//@Component
public class MyAopPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyAopInterface) {
            return Proxy.newProxyInstance(MyAopClassInvocationHandler.class.getClassLoader(), new Class[]{MyAopInterface.class}, new MyAopClassInvocationHandler(bean));
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if (bean instanceof MyAopInterface) {
//            return Proxy.newProxyInstance(MyAopClassInvocationHandler.class.getClassLoader(), new Class[]{MyAopInterface.class}, new MyAopClassInvocationHandler(bean));
//        }
        return bean;
    }
}
