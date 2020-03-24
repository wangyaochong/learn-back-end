package multiThread.atest;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor {


    @Test
    public void testCallerRunsPolicy() {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(3, 6, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0 ; i < 100 ; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                System.out.println("run = " + finalI);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Test
    public void testCoreSize() throws InterruptedException {
        final ThreadPoolExecutor threadPoolExecutor =
//  可以自定义拒绝策略，以阻塞的方式加入任务
                new ThreadPoolExecutor(
                        3,
                        6,
                        0,
                        TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(20),
                        Executors.defaultThreadFactory(),
                        (r, executor) -> {
                            try {
                                executor.getQueue().put(r);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
        new Thread(() -> {
            int count = 0;
            while (true) {
                System.out.println("活跃线程数！" + threadPoolExecutor.getActiveCount());
                System.out.println("待执行任务数！" + threadPoolExecutor.getQueue().size());
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (threadPoolExecutor.getActiveCount() == 0) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= 3) {
                    break;
                }
            }
        }).start();
        for (int i = 0 ; i < 55 ; i++) {
            final int tmp = i;
            threadPoolExecutor.execute(() -> {
                System.out.println("task is executing：" + tmp);
                try {
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("加入=" + i);
            TimeUnit.MILLISECONDS.sleep(5);
        }
        for (int i = 0 ; i < 55 ; i++) {
            final int tmp = i;
            threadPoolExecutor.execute(() -> {
                System.out.println("task is executing：" + tmp);
                try {
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            TimeUnit.SECONDS.sleep(2L);
        }
        synchronized (threadPoolExecutor) {
            threadPoolExecutor.wait();
        }
    }


}
