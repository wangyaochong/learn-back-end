package multiThread.lock.typeReentrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

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
        }, "t1");
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
        }, "t2");
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
                System.out.println("t1 run 上锁");
                TimeUnit.SECONDS.sleep(1000);
                System.out.println("t1醒来了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }, "t1");
        t1.start();
        log.info("t1 start");

        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("线程名" + currentThread().getName());
                lock.lock();
                log.info("t2开始睡眠,中断状态={}", currentThread().isInterrupted());
                TimeUnit.SECONDS.sleep(1);
                log.info("t2结束睡眠");
                lock.unlock();
            } catch (InterruptedException e) {
                log.info("t2被打断");
                e.printStackTrace();
            }
        }, "t2");
        t2.start();
        log.info("t2 start");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("第1次打断t2");
        t2.interrupt();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("第2次打断t2");
        t2.interrupt();
        TimeUnit.SECONDS.sleep(10000);
    }

    @Test
    public void testInterrupt() {
        boolean interrupted = Thread.interrupted();
        currentThread().interrupt();
        currentThread().interrupt();
        currentThread().interrupt();
        System.out.println(currentThread().isInterrupted());
        System.out.println(Thread.interrupted());
        System.out.println(currentThread().isInterrupted());
    }

    @Test
    public void testInterrupt2() throws InterruptedException {
        currentThread().interrupt();//如果提前设置标记为，则在sleep时直接就会抛出InterruptedException
        Thread.sleep(1000);
    }

    @Test
    public void testLockSupport() {
        currentThread().interrupt();

        System.out.println("线程中断状态=" + currentThread().isInterrupted());
        LockSupport.park();
    }
}
