package multiThread.volatile_;

public class TestLoadInteger {
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (flag) {
                    System.out.println("线程1,flag=true");
                    flag = false;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                if (!flag) {
                    System.out.println("线程2,flag=false");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = true;
                }
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(10000000);
    }
}
