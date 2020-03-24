package multiThread.atest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TestThreadLocal {
    public ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Test
    public void test() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("testCoreSize");
        for (int i = 0; i < 20; i++) {
            final Integer temp = i;
            executorService.submit(() -> {
                Integer integer = threadLocal.get();
                if (integer == null) {
                    log.info("threadLocal is null");
                    threadLocal.set(temp);
                }
                log.info("threadLocal={}", threadLocal.get());
            });
        }
        Thread.sleep(2000);
        System.out.println(threadLocal);
    }
}
