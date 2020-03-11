package java8.functionalProgrammingCourse;

import entity.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class c2_FunctionsAreObjects {

    @FunctionalInterface
    interface MyFunction<P, R> {
        R apply(P p);

        static void doNothingStatic() {
        }

        default void doNothingByDefault() {
        }
    }

    @Test
    public void testFunctionalInterface() {
        MyFunction<Integer, Integer> function = a -> a + 5;
        System.out.println(function.apply(10));
    }

    @Test
    public void testInterfacesExample() {
        IntSupplier generator = () -> 2;
        System.out.println(generator.getAsInt());

        IntUnaryOperator toDouble = (e) -> e * 2;
        System.out.println(toDouble.applyAsInt(2));

        IntPredicate isEven = (e) -> e % 2 == 0;
        System.out.println(isEven.test(12));

        Consumer<User> printer = System.out::println;
        printer.andThen((s) -> {
            s.setName("123");
            System.out.println(s);
        }).accept(new User());

        Supplier<User> userSupplier = User::new;
        System.out.println(userSupplier.get());
    }

    @Test
    public void testCallBack() {
        List<String> fruits = Arrays.asList("apple", "orange", "pear", "banana");
        fruits.forEach(System.out::println);

        fruits.forEach(e -> {
            String doubleFruits = e.concat(e);
            if (doubleFruits.length() > 10) {
                System.out.println(doubleFruits);
            }
        });
    }

    @Test
    public void testFunctionComposition() {
        Function<Integer, Integer> add = (x) -> x + 10;
        Function<Integer, Integer> mul = (x) -> x * 5;
        System.out.println(add.andThen(mul).apply(5));//先+10，再×5
        System.out.println(add.compose(mul).apply(5));//先×5，在+10

        List<Integer> collect = IntStream.rangeClosed(1, 30).boxed().collect(Collectors.toList());
        IntPredicate isEven = x -> x % 2 == 0;
        IntPredicate canDivideBy3 = x -> x % 3 == 0;
        IntPredicate combined = isEven.negate().or(canDivideBy3);
        System.out.println("---------------------------开始打印奇数或者能被3整除的数");
        collect.forEach(e -> {
            if (combined.test(e)) {
                System.out.print(e + " ");
            }
        });
        System.out.println();
    }
}
