package multiThread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class TestLock {

    List<Integer> result=new ArrayList<>();
    Object o=new Object();
    public void addToList(int x){
        synchronized (o){
            if(!result.contains(x)){
                result.add(x);
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        for(int i=0;i<10000000;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    addToList(new Random().nextInt(2));
                }
            });
        }
        System.out.println(result);
        TimeUnit.SECONDS.sleep(10);
    }
}
