package multiThread.atest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TestCountDownLatch {

    @Test
    public void test() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int size = 0;
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(finalI);
                    log.info("任务编号：{}，执行结束", finalI);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        log.info("等待执行结束");
        countDownLatch.await();
        log.info("任务执行结束");
    }

    @Test
    public void test2() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                latch.await();
                System.out.println("线程1释放");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                latch.await();
                System.out.println("线程2释放");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(3000);
        latch.countDown();
        Thread.sleep(1000000);
    }
}
