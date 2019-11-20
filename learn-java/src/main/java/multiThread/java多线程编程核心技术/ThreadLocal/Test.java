package multiThread.java多线程编程核心技术.ThreadLocal;

public class Test {
    static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
    static InheritableThreadLocal<Integer> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main value=" + integerThreadLocal.get());
        System.out.println("main value inheritable=" + inheritableThreadLocal.get());
        integerThreadLocal.set(1);
        inheritableThreadLocal.set(1);
        System.out.println("main value=" + integerThreadLocal.get());
        System.out.println("main value inheritable=" + inheritableThreadLocal.get());
        new Thread(() -> {
            System.out.println("thread value=" + integerThreadLocal.get());
            System.out.println("thread value inheritable=" + inheritableThreadLocal.get());
            integerThreadLocal.set(2);
            inheritableThreadLocal.set(2);
            System.out.println("thread value=" + integerThreadLocal.get());
            System.out.println("thread value inheritable=" + inheritableThreadLocal.get());
        }).start();
        Thread.sleep(2000);
        System.out.println("main value=" + integerThreadLocal.get());
        System.out.println("main value inheritable=" + inheritableThreadLocal.get());
    }
}
