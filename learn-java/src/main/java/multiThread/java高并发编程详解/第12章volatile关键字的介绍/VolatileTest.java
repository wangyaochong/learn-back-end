package multiThread.java高并发编程详解.第12章volatile关键字的介绍;

import java.util.concurrent.CountDownLatch;

public class VolatileTest {
    private static volatile int i = 0;
    private static final CountDownLatch latch = new CountDownLatch(10);

    private synchronized static void inc() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
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
