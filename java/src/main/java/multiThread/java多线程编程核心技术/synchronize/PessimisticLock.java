package multiThread.java多线程编程核心技术.synchronize;

import java.util.concurrent.TimeUnit;

public class PessimisticLock {
    public Integer number = 0;

    public synchronized void getAddPrint() throws InterruptedException {
        System.out.println(++number);
        TimeUnit.SECONDS.sleep(2);
    }

    public synchronized void getPrint() throws InterruptedException {
        System.out.println(number);
        TimeUnit.SECONDS.sleep(2);
    }

    public static void main(String[] args) {
        PessimisticLock pessimisticLock = new PessimisticLock();

        new Thread(() -> {
            try {
                pessimisticLock.getPrint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                pessimisticLock.getPrint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
