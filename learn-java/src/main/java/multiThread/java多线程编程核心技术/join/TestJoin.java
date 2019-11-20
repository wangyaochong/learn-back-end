package multiThread.java多线程编程核心技术.join;

import java.util.Random;

public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            Random random = new Random();
            try {
                int i = random.nextInt();
                System.out.println("子线程开始");
                Thread.sleep((i * i % 5) * 1000 + 1000);
                System.out.println("子线程结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.join();
        System.out.println("主线程结束");
    }
}
