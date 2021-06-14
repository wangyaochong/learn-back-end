package basic;

public class TestCast {
    static class A {

    }

    static class B {

    }

    public static void main(String[] args) {
        B b = new B();
      //  A a1 = (A) b; //直接强转无法通过编译

        Object t = b;
        A a2 = (A) t;//使用Object过度可以通过编译，但是运行时会抛异常
    }
}
