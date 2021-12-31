package multiThread.lock;

import cn.hutool.log.Log;
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


    @Test
    public void testTryLock() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1启动了");
                lock.lock();
                System.out.println("t1开始执行任务了");
                Thread.sleep(5 * 1000);
                System.out.println("t1任务执行结束");
                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("t1出现异常了");
            }
        });
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2启动了");
                lock.lock();
                System.out.println("t2开始执行任务了");
              //  Thread.sleep(5 * 1000);
                System.out.println("t2任务执行结束");
                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("t2出现异常了");
            }
        });
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
        System.out.println("线程都启动了");
        Thread.sleep(1000000);

    }
}
