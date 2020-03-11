package multiThread.java高并发编程详解.第10章java类加载器;

public class TestApplicationClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(TestApplicationClassLoader.class.getClassLoader());
    }
}
