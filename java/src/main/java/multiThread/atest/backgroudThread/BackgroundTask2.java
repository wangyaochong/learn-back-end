package multiThread.atest.backgroudThread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BackgroundTask2 {

//    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    String taskName;
    int count = 0;

    public BackgroundTask2(String taskName) {
        this.taskName = taskName;
    }

    public void start() {

        if (!threadPoolExecutor.isShutdown() && count < 5) {
            threadPoolExecutor.submit(() -> {
                System.out.println("start任务在执行,taskName=" + taskName + ",count=" + (++count));
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                start();
            });
        }

    }

    public void stop() {
        threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {

        BackgroundTask2 task1 = new BackgroundTask2("task1");
        task1.start();
        Thread.sleep(5000L);
        BackgroundTask2 task2 = new BackgroundTask2("task2");
        task2.start();
        Thread.sleep(5000L);
        //task1.stop();
        //task2.stop();
        task1.start();
        task2.start();
    }
}
