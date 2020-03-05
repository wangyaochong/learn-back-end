package multiThread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestLockString {
    public static void main(String[] args) throws InterruptedException {
        final String string = "string";
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(() -> {
            System.out.println("开始等待");
            synchronized (string) {
                try {
                    string.wait();
                    System.out.println("等待结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
                String string1 = new String("string");
                synchronized (string1) {
                    string1.notify();
                    System.out.println("复制对象解锁");
                }
                Thread.sleep(1000);
                synchronized (string) {
                    string.notify();
                    System.out.println("原地址对象解锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.awaitTermination(10000, TimeUnit.SECONDS);
    }
}
