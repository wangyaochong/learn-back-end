package multiThread.atest;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor {

    @Test
    public void test() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 100; i++) {
            final int tmp = i;
            threadPoolExecutor.execute(() -> {
                System.out.println("task is executing：" + tmp);
                try {
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        while (threadPoolExecutor.getActiveCount() != 0) {
            System.out.println("活跃线程数！" + threadPoolExecutor.getActiveCount());
            System.out.println("待执行任务数！" + threadPoolExecutor.getQueue().size());
            TimeUnit.SECONDS.sleep(1L);
        }


    }
}
