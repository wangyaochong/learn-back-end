package multiThread.自写线程池;

public interface MyExecutorService {
    void execute(Runnable task);

    void shutdown();

    Runnable getTask();

    int getActiveThread();
}
