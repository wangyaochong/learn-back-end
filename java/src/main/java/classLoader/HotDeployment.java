package classLoader;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * 注意，Demo类的class文件放在D:/classLoader/Demo.class
 *
 * 自定义类加载器
 */
public class HotDeployment {
    public static void main(String[] args) throws Exception {
        MyFileClassLoader classLoader1 = new MyFileClassLoader("D:/");
        MyFileClassLoader classLoader2 = new MyFileClassLoader("D:/", classLoader1);
        //loadClass中包含双亲委派机制，所以同一个类不能加载多次
        Class<?> aClass1 = classLoader1.loadClass("classLoader.Demo");
        Class<?> aClass2 = classLoader2.loadClass("classLoader.Demo");
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());

        MyFileClassLoader classLoader3 = new MyFileClassLoader("D:/");
        MyFileClassLoader classLoader4 = new MyFileClassLoader("D:/", classLoader3);
        //使用find方法，使用多个类加载器可以多次加载同一个类
        Class<?> aClass3 = classLoader3.findClass("classLoader.Demo");
        Class<?> aClass4 = classLoader4.findClass("classLoader.Demo");
        System.out.println(aClass3.hashCode());
        System.out.println(aClass4.hashCode());
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            System.out.println(driver);
        }


    }
}
