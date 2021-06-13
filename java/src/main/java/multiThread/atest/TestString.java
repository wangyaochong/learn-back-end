package multiThread.atest;

import org.junit.Test;

public class TestString {


    @Test
    public void test() {

    }

    public static void main(String[] args) throws InterruptedException {
        class A {
            public String content = "";
        }
        A a = new A();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    a.content = a.content + "1";
                }
            });
            thread.start();
        }
        Thread.sleep(3000);
        System.out.println(a.content);
        System.out.println(a.content.length());
    }
}
