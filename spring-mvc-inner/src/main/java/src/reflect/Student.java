package src.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Student {
    private void sayHello(String name) {
        System.out.println("hello：" + name);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Student> studentClass = Student.class;
        Method sayHello = studentClass.getDeclaredMethod("sayHello", String.class);
        sayHello.setAccessible(true);//在自己这个类中使用反射不用setAccessible
        Object result = sayHello.invoke(new Student(), "张三");
        System.out.println(result);
    }
}
