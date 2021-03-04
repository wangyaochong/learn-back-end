package multiThread.example.forkJoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {


    private static final long threshold = 10000000;
    private final Long start;
    private final Long end;

    public ForkJoinCalculate(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override protected Long compute() {
        long length = end - start;
        if (length < threshold) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long mid = (end - start) / 2 + start;
            ForkJoinCalculate left = new ForkJoinCalculate(start, mid);
            ForkJoinCalculate right = new ForkJoinCalculate(mid + 1, end);
            left.fork();
            right.fork();
            return left.join() + right.join();

        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long end = 30000000000L;
        Instant start = Instant.now();
        ForkJoinCalculate forkJoinCalculate = new ForkJoinCalculate(1L, end);
        ForkJoinPool pool = new ForkJoinPool();
        Long result = pool.submit(forkJoinCalculate).get();
//        Long resul2 = pool.invoke(forkJoinCalculate);
        System.out.println(result);
        Instant endTime = Instant.now();
        System.out.println("耗时=" + Duration.between(start, endTime).toMillis());

        start = Instant.now();
        long sum = 0;
        for (long i = 1; i <= end; i++) {
            sum += i;
        }
        System.out.println(sum);
        endTime = Instant.now();
        System.out.println("耗时=" + Duration.between(start, endTime).toMillis());

        //可以发现，使用forkJoin效率更高

    }

}
