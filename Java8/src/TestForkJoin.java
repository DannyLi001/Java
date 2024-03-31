import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class TestForkJoin {

    /*
     * ForkJoin 框架
     */
    @Test
    public void test1() {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoin(1, 10000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }

    /*
     * for循环
     */
    @Test
    public void test2() {
        Instant start = Instant.now();
        long sum = 0L;
        for (long i = 0; i <= 10000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());

    }

    @Test
    public void test3() {
        LongStream.rangeClosed(0, 100000000000L)
                .parallel() // 并行流
                .reduce(0, Long::sum);
    }
}
