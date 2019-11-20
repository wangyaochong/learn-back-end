package multiThread.java多线程编程核心技术;

public class Synchronized {
    static class MyObject {
        synchronized void methodA() {
            System.out.println("method a");
            try {
                Thread.sleep(1000);
                System.out.println("end a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized void methodB() {//对于synchronized关键字，即使是不同方法，只要有synchronized关键字，都要等待
            System.out.println("method b");
            try {
                Thread.sleep(1000);
                methodA();
                System.out.println("end b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {


        final MyObject myObject = new MyObject();
        new Thread(myObject::methodA).start();
        new Thread(myObject::methodB).start();
        System.out.println(MyObject.class);
        System.out.println(myObject.getClass());


    }
}
