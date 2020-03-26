package multiThread.lock.typeReentrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class TestIsReentrent {
    @Test
    public void test() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        lock.unlock();
        lock.unlock();
        log.info("ss");
    }

    @Test
    public void testLock() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("t1 run");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });
        t1.start();
        log.info("t1 start");

        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread(() -> {
            try {
                lock.lock();
                log.info("t2开始睡眠");
                TimeUnit.SECONDS.sleep(1);
                log.info("t2结束睡眠");
                lock.unlock();
            } catch (InterruptedException e) {
                log.info("t2被打断");
                e.printStackTrace();
            }
        });
        t2.start();
        log.info("t2 start");
        TimeUnit.SECONDS.sleep(1);
        t2.interrupt();
        TimeUnit.SECONDS.sleep(10);
    }


    @Test
    public void testlockInterruptibly() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                System.out.println("t1 run");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });
        t1.start();
        log.info("t1 start");

        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                log.info("t2开始睡眠");
                TimeUnit.SECONDS.sleep(1);
                log.info("t2结束睡眠");
                lock.unlock();
            } catch (InterruptedException e) {
                log.info("t2被打断");
                e.printStackTrace();
            }
        });
        t2.start();
        log.info("t2 start");
        TimeUnit.SECONDS.sleep(5);
        t2.interrupt();
        TimeUnit.SECONDS.sleep(10000);
    }
}
