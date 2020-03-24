package multiThread.example;

import java.util.concurrent.Semaphore;

/**
 * @author wangyaochong
 * @date 2020/3/24 17:44
 */
public class SimpleSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0 ; i < 6 ; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + ",抢到资源了");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + ",释放资源了");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
