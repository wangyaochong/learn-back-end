package multiThread.自写线程池;

public class Task implements Runnable {
    private int number;

    public Task(int i) {
        this.number = i;
    }

    @Override
    public void run() {
        System.out.println("执行当前任务的线程是：" + Thread.currentThread().getName());
        System.out.println("我是任务：" + number);
    }
}
