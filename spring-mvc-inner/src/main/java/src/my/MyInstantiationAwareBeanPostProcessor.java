package src.my;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (beanName.endsWith("testPerson")) {
            System.out.println("testPerson");
        }

        return null;
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化了");
    }
}
