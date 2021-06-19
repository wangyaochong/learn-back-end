package multiThread.java多线程编程核心技术.wait_notify;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitAndNotify {

    @Test
    public void testLock() throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                try {
                    System.out.println("等待");
                    obj.wait();
                    System.out.println("结束等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (obj){
                obj.notifyAll();
            }
            System.out.println("唤醒");
        });
        t1.start();
        TimeUnit.SECONDS.sleep(3);
        t2.start();
    }


    public static void main(String[] args) {
        final String lock = "";
        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("开始等待1");
                    lock.wait();
                    System.out.println("结束等待1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("开始等待2");
                    lock.wait();
                    System.out.println("结束等待2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                    System.out.println("开始通知");
                    //  lock.notify();
                    lock.notifyAll();//如果是notify，只能唤醒一个线程，如果是notifyAll，则可以把该对象下所有wait的线程都唤醒
                    System.out.println("等待1秒");
                    Thread.sleep(1000);//这行代码可以说明，必须等到lock对象锁释放后，wait代码才能恢复运行
                    System.out.println("结束通知");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
