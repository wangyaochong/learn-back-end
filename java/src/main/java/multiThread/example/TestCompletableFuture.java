package multiThread.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author wangyaochong
 * @date 2020/3/25 00:23
 */
public class TestCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行结束");
        });
        Void aVoid = voidCompletableFuture.get();


        CompletableFuture<Integer> voidCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行结束");
            return 21;
        }).whenComplete((a, b) -> {
            System.out.println("结果=" + a);
            System.out.println("异常=" + b);
        }).exceptionally((exception) -> {
            System.out.println("异常了=" + exception);
            return -1;
        });
        Integer integer = voidCompletableFuture2.get();
    }
}
