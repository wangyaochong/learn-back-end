import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import src.bean.OuterSpringClass;
import src.bean.Person;
import src.bean.PersonWrapper;
import src.bean.TestBean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestSpring {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class TestPerson {
        @Resource
        private ApplicationContext context;
        String field;

        @Autowired
        private ApplicationContext context2;


        @Autowired
        private Person person;

        @PostConstruct
        public void init() {
            field = "testField";
        }
    }


    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        TestBean bean = context.getBean(TestBean.class);
        System.out.println(bean);

        Class<TestPerson> personClass = TestPerson.class;
        System.out.println(context.getBeansOfType(personClass));

        System.out.println("begin autowireBeanProperties-------------------------");
        AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();
        PersonWrapper personWrapper = new PersonWrapper();
        autowireCapableBeanFactory.autowireBeanProperties(personWrapper, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
        System.out.println(personWrapper);
        System.out.println("end autowireBeanProperties-------------------------");

        System.out.println("begin autowire----------------------------------");
        OuterSpringClass autowire = (OuterSpringClass) autowireCapableBeanFactory.autowire(OuterSpringClass.class, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
        System.out.println(autowire);
        System.out.println("end autowire----------------------------------");

//        OuterSpringClass outerSpringClassForAutowireBean = new OuterSpringClass();

        OuterSpringClass autowireBean = new OuterSpringClass();
        //这个方法是根据注解来填充对象的，因此需要spring支持注解并扫描到该类，不然无法进行注入（我在测试期间是开启了<mvc:annotation-driven/>和 <context:component-scan base-package="src,src.my,src.bean"/>）
        autowireCapableBeanFactory.autowireBean(autowireBean);
        System.out.println(autowireBean);


    }


    @Test
    public void testArrayToString() {
        System.out.println(Arrays.toString(new int[]{1, 2, 3, 4}));
        System.out.println(Arrays.toString(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(Arrays.deepToString(new int[][]{{1, 2}, {3, 4}}));
    }


    @Test
    public void testStream() {
        List<String> test = new ArrayList<>();
        List<String> collect = test.stream().filter(e -> e.equals("123")).collect(Collectors.toList());
        System.out.println(collect);

    }

}
