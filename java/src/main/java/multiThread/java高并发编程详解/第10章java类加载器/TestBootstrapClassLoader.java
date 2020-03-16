package multiThread.java高并发编程详解.第10章java类加载器;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestBootstrapClassLoader {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry);
        }
        System.out.println("-------------------------------");
        System.out.println(String.class);
        System.out.println("Bootstrap" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));

    }
}
