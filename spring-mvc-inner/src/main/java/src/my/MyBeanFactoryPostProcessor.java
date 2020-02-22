package src.my;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition beanTest = (GenericBeanDefinition) beanFactory.getBeanDefinition("beanTest");
        System.out.println("-------替换了beanTest--------postProcessBeanFactory：" + beanTest);
//        beanTest.setBeanClass(BeanTest2.class);
        System.out.println(beanFactory.getBean("beanTest"));
    }
}
