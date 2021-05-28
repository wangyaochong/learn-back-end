package src.bean.circledepend;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import src.bean.Person;

import javax.annotation.PostConstruct;

@Component
public class A {
    /**
     *
     */
    @PostConstruct
    public void init() {
        System.out.println("-----------A init---------");
    }

    public void init2() {
        System.out.println("-----------A init2---------");
    }

    @Bean
    public Person person() {
        Person person = new Person();
        person.setAge(18);
        person.setName("xxx");
        return person;
    }
}
