package multiThread.atest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wangyaochong
 * @date 2020/3/15 10:51
 */
public class TestFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            Thread.sleep(1000);
            return 5;
        });
        Thread thread = new Thread(futureTask, "futureTask");
        thread.start();
        Integer integer = futureTask.get();
        System.out.println(integer);

    }
}
