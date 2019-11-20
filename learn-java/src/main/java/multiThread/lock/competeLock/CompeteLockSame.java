package multiThread.lock.competeLock;

public class CompeteLockSame {
    String lock = "123";

    public static void main(String[] args) {
        CompeteLockSame competeLockSame = new CompeteLockSame();
        new Thread(() -> {
            synchronized (competeLockSame.lock) {
                System.out.println("enter 1");
                competeLockSame.lock = "345";
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("out 1");
            }
        }).start();
        ///////////////////////////////////////////////这一段，如果加上休眠，则不是竞争同一个锁，第二线程的锁是345，否则，都是竞争锁“123”
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ///////////////////////////////////////////
        new Thread(() -> {
            synchronized (competeLockSame.lock) {
                System.out.println("enter 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                competeLockSame.lock = "345";
                System.out.println("out 2");
            }
        }).start();

    }
}
