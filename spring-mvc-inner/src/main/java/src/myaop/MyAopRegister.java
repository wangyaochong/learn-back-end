package src.myaop;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import javax.annotation.PostConstruct;

public class MyAopRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyAopPostProcessor.class);
        registry.registerBeanDefinition("MyAopPostProcessor", beanDefinitionBuilder.getBeanDefinition());
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }
}
