package multiThread.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author wangyaochong
 * @date 2020/3/24 17:43
 */
public class SimpleCountDownLatch {

    public static void main(String[] args) throws InterruptedException {

        int threadCount = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0 ; i < threadCount ; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("任务," + finalI);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        countDownLatch.await();
        System.out.println("结束");

    }
}
