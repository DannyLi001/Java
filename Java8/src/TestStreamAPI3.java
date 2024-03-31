import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.text.AttributeSet.ColorAttribute;

import org.junit.Test;

import Employee.*;
import Employee.Employee.Status;

public class TestStreamAPI3 {
    List<Employee> employees = Arrays.asList(
            new Employee("name1", 18, 1234, Status.BUSY),
            new Employee("name2", 19, 7645, Status.BUSY),
            new Employee("name3", 10, 5234, Status.BUSY),
            new Employee("name3", 10, 5234, Status.BUSY),
            new Employee("name3", 10, 5234, Status.BUSY),
            new Employee("name4", 70, 2134, Status.BUSY));

    /*
     * 查找与匹配
     * allMatch - 检查是否匹配所有元素
     * anyMatch - 检查是否至少匹配一个元素
     * noneMatch - 检查是否没有比配所有元素
     * findFirst - 返回第一个元素
     * findAny - 返回当前流中的任意元素
     * count - 返回流中的元素数量
     * max - 返回流中的最大值
     * min - 返回流中的最小值
     */

    @Test
    public void test1() {
        boolean b1 = employees.stream()
                .allMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b1);

        boolean b2 = employees.stream()
                .anyMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b2);

        boolean b3 = employees.stream()
                .noneMatch(e -> e.getStatus().equals(Status.BUSY));

        Optional<Employee> op = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op.get());

        Optional<Employee> op2 = employees.stream()
                .filter(e -> e.getStatus().equals(Status.FREE))
                .findAny();
        System.out.println(op2.get());

        employees.stream()
                .count();

        employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        Optional<Double> d = employees.stream()
                .map(Employee::getSalary)
                .min(Double::compare);

    }
    /*
     * 归约
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator) - 可以将流中元素反
     * 复结合起来，得到一个值
     */

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Double> op = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(op.get());
    }

    /*
     * 收集
     * collect - 将流转换为其他形式。接收一个Collector接口的实现，用于
     * 给Stream中元素做汇总的方法
     */
    @Test
    public void test3() {
        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet()); // toList()
        set.forEach(System.out::println);

        HashSet<String> hs = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        Long num = employees.stream()
                .collect(Collectors.counting());

        Double avg = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        Double sum = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));

        Optional<Employee> emp1 = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

        Optional<Double> sal = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));

    }

    // 分组
    @Test
    public void test4() {
        Map<Status, List<Employee>> emps = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        emps.forEach((key, val) -> System.out.println(key + " " + val));
    }

    // 多级分组
    @Test
    public void test5() {
        Map<Status, Map<String, List<Employee>>> emps = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((x) -> {
                    if (((Employee) x).getAge() < 35) {
                        return "young";
                    } else if (((Employee) x).getAge() < 50) {
                        return "mid";
                    } else {
                        return "old";
                    }
                })));
        ;
        emps.forEach((key, val) -> System.out.println(key + "" + val));
    }

    // 分区
    @Test
    public void test6() {
        Map<Boolean,List<Employee>> map = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 5000));
        System.out.println(map);
    }

}
