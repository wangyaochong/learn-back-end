package multiThread.java高并发编程详解.第14章7种单例设计模式.b懒汉式;

public class Singleton {
    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }
}
