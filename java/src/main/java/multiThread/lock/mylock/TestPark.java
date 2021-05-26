package multiThread.lock.mylock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class TestPark {


    @Test
    public void test() throws InterruptedException {

        Thread t = new Thread(()->{
            System.out.println("开始睡眠");
            LockSupport.park();
            System.out.println("被唤醒");
        });
        t.start();

        TimeUnit.SECONDS.sleep(2);
        LockSupport.unpark(t);

    }
}

