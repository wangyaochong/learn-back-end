package multiThread.java高并发编程详解.第14章7种单例设计模式.d_double_check;

public class Singleton {
    private static Singleton instance = null;

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
