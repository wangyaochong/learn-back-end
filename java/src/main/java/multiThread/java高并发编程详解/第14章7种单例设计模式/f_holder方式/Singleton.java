package multiThread.java高并发编程详解.第14章7种单例设计模式.f_holder方式;

public class Singleton {
    private static Singleton instance = null;

    private static class Holder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {

        return Holder.instance;
    }
}
