package multiThread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestExecutors {

    @Test
    public void test() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务");
            }
        });
        executorService.shutdown();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务2");
            }
        });
        TimeUnit.SECONDS.sleep(2);
        boolean terminated = executorService.isTerminated();
        System.out.println(terminated);
    }
}
