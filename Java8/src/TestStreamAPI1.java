import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.*;

import Employee.Employee;

public class TestStreamAPI1 {
    // 1 创建Stream
    @Test 
    public void test1(){
        // 通过Collection系列集合提供的 Stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 通过Arrays中的静态方法Stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);
    
        // 通过Stream类中的静态方法 of()
        Stream<String> stream3 = Stream.of("aa","bb");

        // 创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        // 生成
        Stream.generate(() -> Math.random())
              .forEach(System.out::println);


    }



}
