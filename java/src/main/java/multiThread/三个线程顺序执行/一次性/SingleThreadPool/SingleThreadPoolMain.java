package multiThread.三个线程顺序执行.一次性.SingleThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Thread(() -> {
            System.out.println("t1 start");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 finish");
        }));
        executorService.submit(new Thread(() -> {
            System.out.println("t2 start");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 finish");
        }));
        executorService.submit(new Thread(() -> {
            System.out.println("t3 start");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 finish");
        }));

    }
}
