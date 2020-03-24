package multiThread.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author wangyaochong
 * @date 2020/3/25 00:00
 */
public class TestForkJoinPool {
    public static class MySumCompute extends RecursiveTask<Integer> {
        int start;
        int end;

        public MySumCompute(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start < 10) {
                int sum = 0;
                for (int i = start ; i <= end ; i++) {
                    sum += i;
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                MySumCompute mySumCompute = new MySumCompute(start, mid);
                MySumCompute mySumCompute2 = new MySumCompute(mid + 1, end);
                mySumCompute.fork();
                mySumCompute2.fork();
                return mySumCompute.join() + mySumCompute2.join();
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(new MySumCompute(1, 100));
        System.out.println(submit.get());
    }
}
