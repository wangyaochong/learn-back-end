package multiThread.atest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;

@Slf4j
public class TestCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println("两个任务都结束了"));
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                log.info("thread1结束任务");
                cyclicBarrier.await();
                log.info("thread1结束等待");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                log.info("thread2结束任务");
                cyclicBarrier.await();
                log.info("thread2结束等待");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println(cyclicBarrier.getNumberWaiting());
        System.out.println(cyclicBarrier.getParties());
        log.info("hello");
    }
}
