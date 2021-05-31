package test;

public class Calculator {
    public int add(int a, int b) {
        int i = a + b;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public int addPositive(int a, int b) {
        if (a <= 0 || b <= 0) {
            return 0;
        }
        return add(a, b);
    }

}
