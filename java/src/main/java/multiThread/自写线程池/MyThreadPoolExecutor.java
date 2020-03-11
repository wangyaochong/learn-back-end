package multiThread.自写线程池;

import multiThread.自写线程池.policy.PolicyHandler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPoolExecutor implements MyExecutorService {
    private AtomicInteger aliveThreadCount = new AtomicInteger();
    private BlockingQueue<Runnable> workQueue = null;
    private volatile boolean allowThreadTimeout = false;
    private volatile long keepAliveTime = 0;
    private int poolSize;
    private PolicyHandler handler;
    ReentrantLock mainLock = new ReentrantLock();
    private volatile boolean isShutDown = false;

    public MyThreadPoolExecutor(int poolSize, int queueSize, long keepAliveTime, PolicyHandler handler) {
        if (poolSize <= 0) {
            throw new IllegalArgumentException("核心线程数不能为空");
        }
        this.poolSize = poolSize;
        this.handler = handler;
        this.keepAliveTime = keepAliveTime;
        if (keepAliveTime > 0) {
            allowThreadTimeout = true;
        }
        this.workQueue = new ArrayBlockingQueue<>(5);
    }

    public void execute(Runnable task) {
        if (task == null) {
            throw new NullPointerException("任务不能为空");
        }
        if (isShutDown) {
            throw new IllegalStateException("线程池已经关闭，不接受新的任务");
        }
        int aliveCount = aliveThreadCount.get();
        if (aliveCount < poolSize) {
            //创建核心线程去处理任务
        } else if (workQueue.offer(task)) {

        } else {
            handler.rejected(task, this);
        }

    }


    @Override
    public void shutdown() {
        isShutDown = true;
    }

    @Override
    public Runnable getTask() {
        return null;
    }

    @Override
    public int getActiveThread() {
        return 0;
    }
}
