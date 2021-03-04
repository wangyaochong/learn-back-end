package java8.stream;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.stream.LongStream;

public class TestParallelStream {

    @Test
    public void test() {
        Instant startTime = Instant.now();
        //并行流效率高很多，并行流的底层是使用forkJoin
        OptionalLong reduce = LongStream.rangeClosed(0, 10000000000L).parallel().reduce(Long::sum);
        Instant endTime = Instant.now();
        System.out.println("耗时=" + Duration.between(startTime, endTime).toMillis());

        startTime = Instant.now();
        OptionalLong reduce2 = LongStream.rangeClosed(0, 10000000000L).sequential().reduce(Long::sum);
        endTime = Instant.now();
        System.out.println("耗时=" + Duration.between(startTime, endTime).toMillis());
    }

}
