package multiThread.三个线程顺序执行.一次性.Queue;

import java.util.ArrayList;
import java.util.List;

public class QueueMain {
    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("start thread name = " + finalI);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("end thread name = " + finalI);
            });
            list.add(thread);
        }
        for (Thread thread : list) {
            try {
                thread.start();
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
