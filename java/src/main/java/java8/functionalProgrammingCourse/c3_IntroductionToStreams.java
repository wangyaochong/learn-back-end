package java8.functionalProgrammingCourse;

import entity.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.*;

public class c3_IntroductionToStreams {

    @Test
    public void testCreateStreams() {
        //from collection
        Stream<Integer> integerStream = Arrays.asList(1, 2, 3).stream();
        System.out.println(integerStream.collect(Collectors.toList()));

        //from array
        Stream<Double> doubleStream = Arrays.stream(new Double[]{1.2, 3.4, 4.1, 5.6});
        System.out.println(doubleStream.collect(Collectors.toList()));

        //from string
        IntStream intStream = "abcdefg".chars();
        System.out.println(intStream.boxed().collect(Collectors.toList()));

        //from values
        LongStream longStream = LongStream.of(1L, 2L, 3L);
        System.out.println(longStream.distinct().findFirst());
        Stream<User> userStream = Stream.of(new User(), new User());
        System.out.println(userStream.findFirst());

        //from another stream
        Stream<Integer> concatInteger = Stream.concat(Stream.of(1, 2, 3), Stream.of(3, 4, 5));
        System.out.println(concatInteger.collect(Collectors.toList()));

        //from generate
        Stream<User> generate = Stream.generate(User::new);
        System.out.println(generate.findFirst());
        DoubleStream randomDoubleStream = DoubleStream.generate(Math::random);
        System.out.println(randomDoubleStream.findFirst());

        //from iterate
        IntStream iterate = IntStream.iterate(1, x -> x + 2);
        System.out.println(iterate.boxed().limit(5).collect(Collectors.toList()));
        System.out.println(Stream.iterate(1, x -> x + 1).limit(10).collect(Collectors.toList()));
        System.out.println(DoubleStream.iterate(1, x -> x + 0.1).limit(10).boxed().collect(Collectors.toList()));

        // from range
        System.out.println(IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList()));
    }


    @Test
    public void testIntermediateOperation() {
        System.out.println(
                Stream.iterate(1, x -> x + 1)
                        .limit(100)
                        .filter(x -> x % 2 == 0)
                        .map(x -> x * 10)
                        .distinct()
                        .flatMap(e -> Stream.of(e, e))//flatMap其实不止可以处理子对象，只要返回的是与返回值类型相同的stream即可
                        .sorted((a, b) -> b - a)
                        .collect(Collectors.toList()));
    }

    @Test
    public void testTerminalOperation() {
        System.out.println(Arrays.toString(Stream.iterate(1, x -> x + 1).limit(100).toArray()));
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).max(Comparator.comparingInt(a -> a)));
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count());
        Stream.iterate(1, x -> x + 1).limit(10).forEach(System.out::print);
        System.out.println();
        System.out.println(Stream.iterate(1, x -> x + 1).limit(10).reduce(1, (a, b) -> a + b));
        System.out.println(Stream.iterate(1, x -> x + 1).limit(10).allMatch(x -> x > 0));
        System.out.println(Stream.iterate(1, x -> x + 1).limit(10).anyMatch(x -> x > 0));
        System.out.println(Stream.iterate(1, x -> x + 1).limit(10).noneMatch(x -> x > 0));
    }

    @Test
    public void testStreamStatistic() {
        IntSummaryStatistics intSummaryStatistics = IntStream.rangeClosed(1, 100).summaryStatistics();
        System.out.println(intSummaryStatistics);
    }
}
