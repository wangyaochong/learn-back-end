package multiThread.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangyaochong
 * @date 2020/3/24 17:44
 */
public class SimpleCondition {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("线程1开始等待");
                condition.await();
                System.out.println("线程1结束等待");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        TimeUnit.SECONDS.sleep(3);
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("通知线程1");
                condition.signal();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
