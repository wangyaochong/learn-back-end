package multiThread.java多线程编程核心技术.singleton;

public class MySingleton_4 {//懒汉模式线程安全
    private static MySingleton_4 singleton;

    public synchronized static MySingleton_4 getSingleton() {
        synchronized (MySingleton_4.class) {
            if (singleton == null) {
                singleton = new MySingleton_4();
            }
        }

        return singleton;
    }

}
