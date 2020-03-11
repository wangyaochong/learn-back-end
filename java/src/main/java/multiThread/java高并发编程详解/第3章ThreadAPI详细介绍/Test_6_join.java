package multiThread.java高并发编程详解.第3章ThreadAPI详细介绍;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test_6_join {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                System.out.println("wait 3s");
                try {
                    TimeUnit.SECONDS.sleep(10 - finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ",finish");
            });
            thread.setName("thread," + i);
            thread.start();
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            thread.join();//这个join一定要和start在不同的循环里面，不然会导致start里面的循环阻塞，后面的线程无法start
            System.out.println(thread.getName());
        }
        System.out.println("所有线程执行结束");
    }
}
