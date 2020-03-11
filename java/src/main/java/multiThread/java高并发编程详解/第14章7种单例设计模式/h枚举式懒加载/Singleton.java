package multiThread.java高并发编程详解.第14章7种单例设计模式.h枚举式懒加载;

public class Singleton {

    Singleton() {
        System.out.println("initiated!!!");
    }

    private enum EnumHolder {
        INSTANCE;
        private Singleton instance;

        EnumHolder() {
            this.instance = new Singleton();
        }
    }

    public static Singleton getInstance() {
        return EnumHolder.INSTANCE.instance;
    }
}
