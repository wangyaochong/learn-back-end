package src;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import src.bean.FactoryBeanObject;
import src.bean.circledepend.A;
import src.config.AppConfig;
import src.myaop.MyAopInterface;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        AbstractAutowireCapableBeanFactory beanFactory = (AbstractAutowireCapableBeanFactory) context.getBeanFactory();
// 这个位置可以手动设置循环依赖，还可以实现接口ApplicationContextInitializer<XmlWebApplicationContext>
//        beanFactory.setAllowCircularReferences(false);
//        context.register(AppConfig.class);
//        context.refresh();
        A bean1 = context.getBean(A.class);
        bean1.init2();
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        MyAopInterface bean = context.getBean(MyAopInterface.class);
        bean.method();
        //针对factoryBean调用getBean，会返回factoryBean的getObject返回的对象
        System.out.println(context.getBean(FactoryBeanObject.class));
        System.out.println(context.getBean("myFactoryBean"));
//        System.out.println(bean);
    }
}
