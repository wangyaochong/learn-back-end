package multiThread.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestTryLock {

    @Test
    public void test() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread(lock::lock).start();

        Thread.sleep(1000);

        boolean b = lock.tryLock(5, TimeUnit.SECONDS);
        if (b) {
            System.out.println("获取到锁了");
        } else {
            System.out.println("没有获取到锁");
        }
    }
}
