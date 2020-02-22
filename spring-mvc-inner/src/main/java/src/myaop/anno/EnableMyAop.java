package src.myaop.anno;

import org.springframework.context.annotation.Import;
import src.myaop.MyAopRegister;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import(MyAopRegister.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableMyAop {
}
