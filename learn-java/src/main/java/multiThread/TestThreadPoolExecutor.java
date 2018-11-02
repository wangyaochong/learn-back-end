package multiThread;

import org.junit.Test;

import java.util.concurrent.*;

public class TestThreadPoolExecutor {

    @Test
    public void test() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5,5,50,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        for(int i=0;i<100;i++){
            final int tmp=i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task is executing："+tmp);
                }
            });
        }
        BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
        while (threadPoolExecutor.getActiveCount()!=0){
            System.out.println("活跃线程数！"+threadPoolExecutor.getActiveCount());
        }


    }
}
