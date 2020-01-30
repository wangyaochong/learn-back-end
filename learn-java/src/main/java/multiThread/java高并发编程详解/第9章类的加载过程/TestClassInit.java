package multiThread.java高并发编程详解.第9章类的加载过程;

public class TestClassInit {
    static int x = 10;

    static {
//        System.out.println(x);//如果x声明在前面就可以访问，否则不能访问
        x = 20;//不论声明在什么位置，x可以被赋值
//        System.out.println(x);//如果x声明在前面就可以访问，否则不能访问

    }

    // static int x = 10;

    public static void main(String[] args) {
        System.out.println(x);//如果static代码块在声明后，则x=20，否则x=10
    }

}
