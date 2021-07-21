package multiThread.java多线程编程核心技术.lock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestWriteReadLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        new Thread(() -> {
            readWriteLock.writeLock().lock();
            try {
                System.out.println("开始写任务1");
                Thread.sleep(1000);
                System.out.println("结束写任务1");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readWriteLock.writeLock().unlock();
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            readWriteLock.readLock().lock();
            try {
                System.out.println("开始读任务2");
                Thread.sleep(1000);
                System.out.println("结束读任务2");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readWriteLock.readLock().unlock();
        }).start();
    }
}
