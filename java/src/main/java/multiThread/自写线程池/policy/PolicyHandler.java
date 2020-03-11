package multiThread.自写线程池.policy;

import multiThread.自写线程池.MyExecutorService;

public interface PolicyHandler {
    void rejected(Runnable task, MyExecutorService executorService);
}
