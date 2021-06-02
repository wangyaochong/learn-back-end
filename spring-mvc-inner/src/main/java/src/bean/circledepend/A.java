package src.bean.circledepend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import src.bean.Person;

import javax.annotation.PostConstruct;

@Component
public class A {
    /**
     *
     */

    B b;

    @Autowired
    public void setB(B b) {
        this.b = b;
    }

    @PostConstruct
    public void init() {

        System.out.println("-----------A init---------");
        System.out.println("b=" + this.b);
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
