package multiThread.java多线程编程核心技术.singleton;

public class MySingleton_1 {//饿汉单例模式
    private static MySingleton_1 singleton = new MySingleton_1();

    public static MySingleton_1 getSingleton() {
        return singleton;
    }

}
