package multiThread.lock.deadLock;

public class DeadLock {
    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();
        new Thread(() -> {
            synchronized (a) {
                System.out.println("a get");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("b get");
                }
            }

        }).start();
        new Thread(() -> {
            synchronized (b) {
                System.out.println("b get");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println("a get");
                }
            }

        }).start();
        System.out.println("main finish");
    }
}
