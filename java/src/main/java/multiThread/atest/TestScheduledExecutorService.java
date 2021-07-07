package multiThread.atest;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledExecutorService {
    final Object obj = new Object();

    @Test
    public void test() throws InterruptedException {
        System.out.println("start");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(() -> {
            System.out.println("延时打印");
            synchronized (obj){
                obj.notifyAll();
            }
        }, 5, TimeUnit.SECONDS);
        synchronized (obj){
            obj.wait();
        }
        System.out.println("end");
    }
}
