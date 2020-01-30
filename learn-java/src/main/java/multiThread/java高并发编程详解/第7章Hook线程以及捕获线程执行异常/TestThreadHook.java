package multiThread.java高并发编程详解.第7章Hook线程以及捕获线程执行异常;

public class TestThreadHook {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("hook started");
        }));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("hook started");
        }));
        System.out.println("main ended");
    }
}
