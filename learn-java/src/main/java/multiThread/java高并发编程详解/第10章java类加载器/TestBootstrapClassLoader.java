package multiThread.java高并发编程详解.第10章java类加载器;

public class TestBootstrapClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class);
        System.out.println("Bootstrap" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));

    }
}
