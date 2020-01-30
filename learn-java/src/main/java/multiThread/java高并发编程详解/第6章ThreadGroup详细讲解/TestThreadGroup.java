package multiThread.java高并发编程详解.第6章ThreadGroup详细讲解;

import java.util.concurrent.TimeUnit;

public class TestThreadGroup {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group1 = new ThreadGroup("group1");
        new Thread(group1, () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        ThreadGroup group2 = new ThreadGroup("group1");
        new Thread(group2, () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        group2.setDaemon(true);
        TimeUnit.SECONDS.sleep(4);
        System.out.println(group1.isDestroyed());
        System.out.println(group2.isDestroyed());
    }
}
