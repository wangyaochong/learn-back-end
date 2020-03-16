package multiThread.java高并发编程详解.第12章volatile关键字的介绍;

import java.util.concurrent.CountDownLatch;

public class VolatileTest {
    private static volatile int i = 0;
    static int threadCount = 100;
    private static CountDownLatch latch = null;

    private synchronized static void inc() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        latch = new CountDownLatch(100);
        for (int i = 0 ; i < threadCount ; i++) {
            new Thread(() -> {
                for (int x = 0; x < 1000; x++) {
                    inc();
                }
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println(i);
    }
}
