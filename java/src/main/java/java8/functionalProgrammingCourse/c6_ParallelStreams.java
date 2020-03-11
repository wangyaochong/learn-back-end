package java8.functionalProgrammingCourse;

import org.junit.Test;

import java.util.stream.IntStream;

public class c6_ParallelStreams {


    @Test
    public void testParallelStreams() {
        IntStream.rangeClosed(1, 20).boxed().map(e -> e * 2 + " ").forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1, 20).boxed().parallel().map(e -> e * 2 + " ").forEach(System.out::print); // parallel会乱序
        System.out.println();
        IntStream.rangeClosed(1, 20).boxed().parallel().map(e -> e * 2 + " ").forEachOrdered(System.out::print); // 使用foreachOrdered保持顺序

        System.out.println();
        System.out.println(IntStream.rangeClosed(1, 20).boxed().reduce(1000, (a, b) -> a + b));//只会加1个1000
        System.out.println(IntStream.rangeClosed(1, 20).boxed().parallel().reduce(1000, (a, b) -> a + b));//有几个parallel就会+几个1000

        /**
         * 总结：对顺序有要求时，在使用Parallel Stream时一定要小心
         */
    }
}
