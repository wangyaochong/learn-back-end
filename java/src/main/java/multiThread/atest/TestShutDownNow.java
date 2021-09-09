package multiThread.atest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestShutDownNow {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        AtomicInteger atomicInteger = new AtomicInteger();
        threadPoolExecutor.submit(() -> {
            while (true) {
                System.out.println("hello"+atomicInteger.getAndIncrement());
                try{

                    Thread.sleep(1000L);
                }catch (Exception e){
                    System.out.println("出现异常");
                }
            }
        });
        Thread.sleep(5000);
        threadPoolExecutor.shutdownNow();//shutdownNow，如果是死循环，并不能退出
    }
}
