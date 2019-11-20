package multiThread.java多线程编程核心技术.singleton;

public class MySingleton_2 {//懒汉模式线程不安全
    private static MySingleton_2 singleton;

    public static MySingleton_2 getSingleton() {
        if (singleton == null) {
            singleton = new MySingleton_2();
        }
        return singleton;
    }

}
