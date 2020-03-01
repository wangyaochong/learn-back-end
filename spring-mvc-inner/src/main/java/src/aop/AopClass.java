package src.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopClass {
    @Pointcut("execution(* src.bean.circledepend.*.*(..))")
    public void anyPublicMethod() {

    }

    @Before("anyPublicMethod()")
    public void log() {
        System.out.println("-------测试AOP--------");
    }
}
