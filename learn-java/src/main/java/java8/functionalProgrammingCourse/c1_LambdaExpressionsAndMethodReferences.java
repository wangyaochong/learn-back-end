package java8.functionalProgrammingCourse;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class c1_LambdaExpressionsAndMethodReferences {
    @Test
    public void testLambdaExpression() {
        Function<Integer, Integer> add5 = e -> e + 5;
        System.out.println(add5.apply(1));
        Function<Integer, Integer> add5WithType = (Integer e) -> e + 5;//显示声明入参类型
        System.out.println(add5WithType.apply(1));

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(1, 2));


    }

    @Test
    public void testMethodReferences() {
        Function<Double, Double> sqrt = Math::sqrt;
        System.out.println(sqrt.apply(4.0));

        Supplier<String> stringSupplier = String::new;
        System.out.println("string value is:" + stringSupplier.get());
    }

    @Test
    public void testClosure() {
        String greeting = "hello";
        Function<String, String> greetingFunction = (a) -> greeting.concat(",").concat(a);
        System.out.println(greetingFunction.apply("wangyaochong"));
    }

}
