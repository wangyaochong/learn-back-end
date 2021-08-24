package multiThread.atest.backgroudThread;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadPoolExecutorRecycle {

    @Test
    public void test() throws InterruptedException {
        runTask();
    }

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void runTask() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 2, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                r -> new Thread(r, "TestThreadPoolExecutorRecycle-" + atomicInteger.getAndIncrement()));
        threadPoolExecutor.submit(() -> {
            System.out.println("hello");
        });
        Thread.sleep(1000L);
        runTask();
    }
}
