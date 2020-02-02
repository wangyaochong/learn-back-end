package multiThread.java高并发编程详解.第14章7种单例设计模式.g枚举式;

public enum Singleton {
    INSTANCE;

    Singleton() {
        System.out.println("initiated!!!");
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
