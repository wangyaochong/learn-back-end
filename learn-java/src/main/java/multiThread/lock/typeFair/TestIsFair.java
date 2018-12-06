package multiThread.lock.typeFair;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class TestIsFair {
    public void RunNotFair(int id){
        log.info("id={}开始执行任务",id);
        synchronized (NotFairTask.class){
            try {
                Thread.sleep(100);
                log.info("id={}任务执行结束",id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    ReentrantLock lock=new ReentrantLock(true);

    public void RunFair(int id){

        log.info("id={}开始执行任务",id);
        try {
            lock.lock();
            Thread.sleep(100);
            log.info("id={}任务执行结束",id);
        }catch (InterruptedException e){
        } finally {
            lock.unlock();
        }
    }
    class NotFairTask implements Runnable{
        int id;
        public NotFairTask(int id){
            this.id=id;
        }
        @Override
        public void run() {
            RunNotFair(id);
        }
    }
    class FairTask implements Runnable{
        int id;
        public FairTask(int id){
            this.id=id;
        }
        @Override
        public void run() {
            RunFair(id);
        }
    }
    @Test
    public void test() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            executorService.execute(new NotFairTask(i));
//            executorService.execute(new FairTask(i));
            Thread.sleep(10);
        }

        Thread.sleep(3000);
    }
}
