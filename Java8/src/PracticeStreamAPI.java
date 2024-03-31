import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import Employee.Employee;
import Employee.Employee.Status;

public class PracticeStreamAPI {
    List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

    List<Employee> employees = Arrays.asList(
            new Employee("name1", 18, 1234, Status.BUSY),
            new Employee("name2", 19, 7645, Status.BUSY),
            new Employee("name3", 10, 5234, Status.BUSY),
            new Employee("name3", 10, 5234, Status.BUSY),
            new Employee("name3", 10, 5234, Status.BUSY),
            new Employee("name4", 70, 2134, Status.BUSY));

    @Test
    public void test1() {
        nums.stream()
                .forEach(x -> System.out.println(x * x));

        nums.stream()
                .map(x -> x * x)
                .forEach(System.out::println);

        Optional<Integer> count = nums.stream()
                .map(e -> 1)
                .reduce(Integer::sum);

    }

}
