package classLoader;

import sun.net.spi.nameservice.dns.DNSNameService;

public class ClassLoaderDemo1 {
    public static void main(String[] args) {
        //很多用到的类都在rt.jar中
        ClassLoader rootClassLoader = Object.class.getClassLoader();//根加载器
        System.out.println(rootClassLoader);
        System.out.println("-----------------------------");
        ClassLoader extClassLoader = DNSNameService.class.getClassLoader();//扩展类加载器
        System.out.println(extClassLoader);
        System.out.println("----------------------------");
        ClassLoader appClassLoader = ClassLoaderDemo1.class.getClassLoader();//系统类加载器
        System.out.println(appClassLoader);
        System.out.println("----------------------------");

        while (appClassLoader != null) {//类加载器具有父子关系
            System.out.println(appClassLoader);
            appClassLoader = appClassLoader.getParent();
        }
    }
}
