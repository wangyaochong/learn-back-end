package multiThread.三个特性;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangyaochong
 * @date 2020/3/27 21:07
 */
public class Test1Atomic {
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int x = 0 ; x < 100 ; x++) {
            new Thread(() -> {
                for (int y = 0 ; y < 1000 ; y++) {
                    i++;
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(i);
    }

}
