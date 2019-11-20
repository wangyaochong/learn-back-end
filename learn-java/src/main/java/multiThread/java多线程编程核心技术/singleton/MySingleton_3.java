package multiThread.java多线程编程核心技术.singleton;

public class MySingleton_3 {//懒汉模式线程安全
    private static MySingleton_3 singleton;

    public synchronized static MySingleton_3 getSingleton() {
        if (singleton == null) {
            singleton = new MySingleton_3();
        }
        return singleton;
    }

}
