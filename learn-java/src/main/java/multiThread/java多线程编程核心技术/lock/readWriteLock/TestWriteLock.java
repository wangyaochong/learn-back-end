package multiThread.java多线程编程核心技术.lock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestWriteLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        new Thread(() -> {
            readWriteLock.writeLock().lock();
            try {
                System.out.println("开始任务1");
                Thread.sleep(1000);
                System.out.println("结束任务1");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readWriteLock.writeLock().unlock();
        }).start();
        new Thread(() -> {
            readWriteLock.writeLock().lock();
            try {
                System.out.println("开始任务2");
                Thread.sleep(1000);
                System.out.println("结束任务2");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readWriteLock.writeLock().unlock();
        }).start();
    }
}
