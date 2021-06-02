package test;

import java.util.Vector;

public class Calculator {
    public int add(int a, int b) {
        int i = a + b;
        result.add(i);
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

    public Vector<Integer> result = new Vector<>();

}
