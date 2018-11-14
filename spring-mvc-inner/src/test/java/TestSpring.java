import org.junit.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import src.bean.OuterSpringClass;
import src.bean.Person;
import src.bean.PersonWrapper;
import src.bean.TestBean;

import java.util.Arrays;

public class TestSpring {

    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        TestBean bean = context.getBean(TestBean.class);
        System.out.println(bean);

        Class<Person> personClass = Person.class;
        System.out.println(context.getBeansOfType(personClass));

        System.out.println("begin autowireBeanProperties-------------------------");
        AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();
        PersonWrapper personWrapper=new PersonWrapper();
        autowireCapableBeanFactory.autowireBeanProperties(personWrapper,AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE,true);
        System.out.println(personWrapper.getPerson());
        System.out.println("end autowireBeanProperties-------------------------");

        System.out.println("begin autowire----------------------------------");
        OuterSpringClass autowire = (OuterSpringClass) autowireCapableBeanFactory.autowire(OuterSpringClass.class, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
        System.out.println(autowire);
        System.out.println("end autowire----------------------------------");


    }


    @Test
    public void testArrayToString(){
        System.out.println(Arrays.toString(new int[]{1, 2,3, 4}));
        System.out.println(Arrays.toString(new int[][]{{1, 2},{ 3, 4}}));
        System.out.println(Arrays.deepToString(new int[][]{{1, 2},{ 3, 4}}));
    }


}
