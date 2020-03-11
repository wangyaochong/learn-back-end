package multiThread.java高并发编程详解.第7章Hook线程以及捕获线程执行异常;

import java.util.concurrent.TimeUnit;

public class TestExceptionHandler {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(1 / 0);
        });
//        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.out.println("捕获异常.......");
//                e.printStackTrace();
//            }
//        });
        thread.start();
        TimeUnit.SECONDS.sleep(10);
    }
}
