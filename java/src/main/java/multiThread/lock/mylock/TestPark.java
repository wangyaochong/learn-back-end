package multiThread.lock.mylock;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class TestPark {


    @Test
    public void test() throws InterruptedException {
        Object blocker = new Object();
        Thread t = new Thread(() -> {
            System.out.println("开始睡眠");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println("被唤醒");
        });
        t.start();

        TimeUnit.SECONDS.sleep(2);
        LockSupport.unpark(t);
        Thread.sleep(5000L);
    }

    @Test
    public void testCountDownLatch() {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount());
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount());
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount());

    }

    @Test
    public void testInterrupt() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("开始睡眠");
            LockSupport.park();
            System.out.println("被唤醒了");
        });
        thread.start();
        Thread.sleep(1000);
        LockSupport.unpark(thread);
        Thread.sleep(100000);
    }
}

