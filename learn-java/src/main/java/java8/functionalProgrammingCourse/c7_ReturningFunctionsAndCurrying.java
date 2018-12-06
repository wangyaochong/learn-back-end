package java8.functionalProgrammingCourse;

import org.junit.Test;

import java.util.function.*;

public class c7_ReturningFunctionsAndCurrying {

    public static IntBinaryOperator sumF(IntUnaryOperator f) {
        return (a, b) -> (f.applyAsInt(a) + f.applyAsInt(b));
    }


    @Test
    public void testReturningFunctions() {//使用函数构造函数
        IntBinaryOperator binaryOperator = sumF(x -> x * x);
        System.out.println(binaryOperator.applyAsInt(5, 10));
    }

    @Test
    public void testCurring() {
        IntBinaryOperator notCurried = (a, b) -> a + b;
        System.out.println(notCurried.applyAsInt(2, 8));
        IntFunction<IntUnaryOperator> curriedFunc = x -> y -> x + y;
        System.out.println(curriedFunc.apply(2).applyAsInt(8));

        IntFunction<IntFunction<IntFunction<Integer>>> functionIntFunction = x -> y -> z -> x * y + z;
        System.out.println(functionIntFunction.apply(2).apply(3).apply(4));
    }

    @Test
    public void testFunction() {
        Function<Integer, Function<Integer, Function<Integer, Integer>>> funSquare = x -> y -> z -> x * y + z;
        System.out.println(funSquare.apply(2).apply(3).apply(4));
    }


    @Test
    public void testConsumer() {//consumer其实就是一个不带返回值的函数
        Function<String, Consumer<String>> function = x -> y -> System.out.println(x + ":" + y + "!");
        Consumer<String> hello = function.apply("hello");
        hello.accept("王耀冲");
        Consumer<String> hi = function.apply("hi");
        hi.accept("王耀冲");
    }

}
