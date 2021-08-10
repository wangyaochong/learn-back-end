package multiThread.java多线程编程核心技术.wait_notify;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class WaitAndNotifyMultiTimes {

    @Test
    public void testMultiNotify() throws InterruptedException {
        Object obj = new Object();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj){
                obj.notifyAll();
            }
            System.out.println("第一次notify");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj){
                obj.notifyAll();
            }
            System.out.println("第二次notify");
        }).start();
        synchronized (obj){
            obj.wait(10000L);
        }
        Thread.sleep(1000);
        System.out.println("程序结束");
    }
    @Test
    public void testMultiWait() throws InterruptedException {
        Object obj = new Object();
        new Thread(() -> {
            synchronized (obj){
                try {
                    obj.wait(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("第一次wait释放");
        }).start();

        new Thread(() -> {
            synchronized (obj){
                try {
                    obj.wait(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("第二次wait释放");
        }).start();
        Thread.sleep(3000);
        synchronized (obj){
            obj.notifyAll();
        }
        Thread.sleep(3000);
        System.out.println("程序结束");
    }
}
