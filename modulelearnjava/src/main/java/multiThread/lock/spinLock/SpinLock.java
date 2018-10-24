package multiThread.lock.spinLock;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
@Slf4j
public class SpinLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();
    public void lock() {
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null, current)) {
        }
    }
    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }



    static SpinLock lock=new SpinLock();
    public void RunSpinLock(int id){
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
    class SpinLockTask implements Runnable{
        int id;
        public SpinLockTask(int id){
            this.id=id;
        }
        @Override
        public void run() {
            RunSpinLock(id);
        }
    }

    @Test
    public void testMulti() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
//            executorService.execute(new NotFairTask(i));
            executorService.execute(new SpinLockTask(i));
            Thread.sleep(10);
        }

        Thread.sleep(3000);
    }

    @Test
    public void test() throws InterruptedException {
        SpinLock spinLock=new SpinLock();
        spinLock.lock();
        System.out.println("locked");
        Thread.sleep(1000);
    }
}
