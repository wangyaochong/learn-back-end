package com.learnspringboot.learnSubject.annotations.lookup;

import lombok.Data;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@Data
public class ClassB extends ClassBase {
    public ClassB() {
        super(System.currentTimeMillis());
    }

}
