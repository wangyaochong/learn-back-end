package src.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Student> studentClass = Student.class;
        Method sayHello = studentClass.getDeclaredMethod("sayHello", String.class);
        sayHello.setAccessible(true);
        Object result = sayHello.invoke(new Student(), "张三");
        System.out.println(result);
    }
}
