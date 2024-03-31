import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import Employee.Employee;

public class TestStreamAPI2 {
    List<Employee> employees = Arrays.asList(
            new Employee("name1", 18, 1234),
            new Employee("name2", 19, 7645),
            new Employee("name3", 10, 5234),
            new Employee("name3", 10, 5234),
            new Employee("name3", 10, 5234),
            new Employee("name4", 70, 2134));
    // 2 中间操作
    /*
     * 筛选与切片
     * filter - 接受Lambda，从流中排除某些元素
     * limit - 截断流，使元素不超过给定数量
     * skip - 跳过元素，返回一个人掉了前n个元素的流。若流中元素不够，则返回空流
     * distinct - 筛选，通过流产生的元素 hashCode 和 equals 去除重复元素
     */

    @Test
    public void test4() {
        employees.stream()
                .filter(x -> x.getAge() < 15)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        employees.stream()
                .filter(x -> {
                    System.out.println("something");
                    return x.getAge() > 15;
                }) // 短路
                .limit(3)
                .forEach(System.out::println);
    }

    /*
     * 映射：
     * map - 接收Lambda，将元素转换成其他形式或提取信息，该函数会被引用刀每个元素
     * 上，并将其映射成一个新的元素
     * 
     * flatMap - 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流
     * 连接成一个流
     */
    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        list.stream().map(str -> str.toUpperCase())
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getAge)
                .forEach(System.out::println);

        Stream<Stream<Character>> stream = list.stream()
                .map(TestStreamAPI2::filterCharacter);
        stream.forEach(sm -> sm
                .forEach(System.out::println));

        // flatMap
        Stream<Character> stream2 = list.stream()
                .flatMap(TestStreamAPI2::filterCharacter);
        stream2.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

    /*
     * 排序
     * sorted() - 自然排序(Comparable)
     * sorted(Comparator com) - 定制排序
     */

    @Test
    public void test6() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");

        list.stream()
                .sorted()
                .forEach(System.out::println);

        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge().equals(e2.getAge())) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return e1.getAge().compareTo(e2.getAge());
                    }
                })
                .forEach(System.out::println);
    }

    /*
     * 多个中间操作可以连接起来形成一个流水线，除非流水线上触发
     * 终止操作，否则中间操作不会执行任何处理，而在终止操作时一
     * 次性全部处理 - 惰性求值
     */

    // 内部迭代：迭代操作由Stream API完成
    @Test
    public void test1() {
        // 中间操作：不会执行任何操作
        Stream<Employee> s = employees.stream()
                .filter((x) -> {
                    System.out.println("something");
                    return x.getAge() > 35;
                });
        // 终止操作：一次性执行全部内容
        s.forEach(System.out::println);
    }

    // 外部迭代：
    @Test
    public void test2() {
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

}
