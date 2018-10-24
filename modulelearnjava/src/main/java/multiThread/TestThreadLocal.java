package multiThread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Slf4j
public class TestThreadLocal {
    public ThreadLocal<Integer>threadLocal=new ThreadLocal<>();
    @Test
    public void test() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("test");
        for(int i=0;i<10;i++){
            final  Integer temp=i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Integer integer = threadLocal.get();
                    log.info("get count=".concat(temp.toString()).concat(", threadLocal="+integer));
                    threadLocal.set(temp);
                    log.info("get after set count=".concat(temp.toString()).concat(", threadLocal="+threadLocal.get()));
                }
            });
        }
        Thread.sleep(2000);
        System.out.println(threadLocal);
    }
}
