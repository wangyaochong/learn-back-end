package multiThread.java多线程编程核心技术;

public class DeamonThread {
    static class MyThread extends Thread {
        String name;

        MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 50000; i++) {
                System.out.println(i + this.name);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread deamonThread = new MyThread("deamon");
        MyThread normalThread = new MyThread("normal");
        normalThread.setDaemon(true);
        deamonThread.setDaemon(true);
        //如果是守护线程，则非守护线程结束，守护线程自动终止
        //如果不是守护线程，则会一直在后台运行
        deamonThread.start();
        normalThread.start();
        Thread.sleep(10);
    }
}
