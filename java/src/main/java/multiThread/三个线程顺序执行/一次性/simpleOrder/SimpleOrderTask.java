package multiThread.三个线程顺序执行.一次性.simpleOrder;

public class SimpleOrderTask extends Thread {
    private final String name;
    private final Thread after;

    public SimpleOrderTask(String name, Thread next) {
        this.name = name;
        this.after = next;
    }

    @Override public void run() {
        System.out.println("start run " + this.name);
        try {
            Thread.sleep(1000);
            System.out.println("finish run " + this.name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (this.after != null) {
            this.after.start();
        }
    }
}
