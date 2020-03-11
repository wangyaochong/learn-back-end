package multiThread.java高并发编程详解.第14章7种单例设计模式.e_volatile_double_check;

public class Singleton {
    private volatile static Singleton instance = null;

    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
