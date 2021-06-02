package test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Before
    public void setUp() {
        System.out.println("setUp");
    }

    @Test
    public void testDropFram() {
        Calculator calculator = new Calculator();
        call(calculator);
    }

    public void call(Calculator calculator) {
        System.out.println("开始计算");
        calculator.add(1, 2);
        System.out.println("结束计算");
    }

    @Test
    public void add() {
        Calculator calculator = new Calculator();
        int add = calculator.add(1, 2);
        int zero = calculator.add(Integer.MAX_VALUE, 5);
        assertEquals(add, 3);
        assertEquals(zero, 0);
    }

    @Test
    public void addPositive() {
        Calculator calculator = new Calculator();
        checkSuccess(calculator.addPositive(-1, 2), 0);
        checkSuccess(calculator.addPositive(1, -2), 0);
        checkSuccess(calculator.addPositive(1, 2), 3);
    }

    public void checkSuccess(int calculate, int expect) {
        assertEquals(calculate, expect);
    }
}