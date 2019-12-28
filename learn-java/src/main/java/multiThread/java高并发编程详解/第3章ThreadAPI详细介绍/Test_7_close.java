package multiThread.java高并发编程详解.第3章ThreadAPI详细介绍;

import java.util.concurrent.TimeUnit;

public class Test_7_close {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("正在执行任务");
            }
            System.out.println("任务结束");
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("中断线程");
        thread.interrupt();
    }
}
