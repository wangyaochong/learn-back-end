package multiThread.三个线程顺序执行.一次性.Join;

public class JoinTask extends Thread {
    private final String name;
    private final Thread pre;

    public JoinTask(String name, Thread pre) {
        this.name = name;
        this.pre = pre;
    }

    @Override
    public void run() {
        try {
            if (this.pre != null) {
                this.pre.join();
            }
            System.out.println("start run " + this.name);
            Thread.sleep(1000);
            System.out.println("finish run " + this.name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
