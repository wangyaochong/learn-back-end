package multiThread.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author wangyaochong
 * @date 2020/3/24 17:43
 */
public class SimpleCyclicBarrier {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        int threadCount = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);

//        如果需要主线也等待，则总线程数需要+1
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount + 1);
        for (int i = 0 ; i < threadCount ; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("任务," + finalI);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    cyclicBarrier.await();
                    System.out.println("所有线程结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
//        cyclicBarrier.await();
        System.out.println("主线程结束");

        cyclicBarrier.reset();

    }
}
