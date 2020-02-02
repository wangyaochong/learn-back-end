package multiThread.java高并发编程详解.第14章7种单例设计模式.a饿汉式;

public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }
}
