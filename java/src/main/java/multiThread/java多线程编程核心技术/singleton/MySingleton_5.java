package multiThread.java多线程编程核心技术.singleton;

public class MySingleton_5 {//懒汉模式线程安全高效
    private static MySingleton_5 singleton;

    public synchronized static MySingleton_5 getSingleton() {
        if (singleton == null) {
            synchronized (MySingleton_5.class) {
                if (singleton != null) {
                    singleton = new MySingleton_5();
                }
            }
        }
        return singleton;
    }

}
