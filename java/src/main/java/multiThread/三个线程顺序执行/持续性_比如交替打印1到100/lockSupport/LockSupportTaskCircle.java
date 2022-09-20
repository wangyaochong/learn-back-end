package multiThread.三个线程顺序执行.持续性_比如交替打印1到100.lockSupport;

import lombok.Setter;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTaskCircle extends Thread {
    private final String name;
    private final AtomicInteger count;
    private static final AtomicBoolean isFirst = new AtomicBoolean(true);
    @Setter
    private Thread next;

    public LockSupportTaskCircle(String name, Thread next, AtomicInteger count) {
        this.name = name;
        this.count = count;
        this.next = next;
    }


    @Override public void run() {
        while (count.get() < 100) {
            boolean b = isFirst.compareAndSet(true, false);//并发只有一次会成功，唯一成功的这一次不需要await，其他的都需要await
            if (!b) {
                LockSupport.park();
            }
            if (count.get() >= 100) {
                LockSupport.unpark(next);//用于终止任务
                break;
            }
            System.out.println("start run " + this.name + " " + count.get());
            count.incrementAndGet();
            System.out.println("finish run " + this.name + " " + count.get());
            LockSupport.unpark(next);
        }
    }
}
