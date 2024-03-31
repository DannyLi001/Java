import java.beans.Transient;
import java.io.PrintStream;
import java.nio.charset.UnmappableCharacterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.*;

import Employee.Employee;

public class TestMethodRef {
    @Test
    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;
        con1.accept("something");
    }

    @Test
    public void test2() {
        Employee emp = new Employee();
        Supplier<String> sup1 = () -> emp.getName();
        String name = sup1.get();
        System.out.println(name);

        Supplier<Integer> sup = emp::getAge;
        int num = sup.get();
        System.out.println(num);
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = Integer::compare;
    }

    @Test
    public void test4() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);

        BiPredicate<String, String> bp2 = String::equals;
    }

    @Test
    public void test5() {
        Supplier<Employee> sup = () -> new Employee();
        sup.get();
        // 无参构造器
        Supplier<Employee> sup1 = Employee::new;
        // 带参构造器
        Function<String, Employee> fn1 = Employee::new;
        Employee emp = fn1.apply("name5");
        System.out.println(emp);
    }

    @Test
    public void test6() {
        Function<Integer, String[]> fn = x -> new String[x];
        String[] strs = fn.apply(10);
        System.out.println(strs.length);

        Function<Integer, String[]> fn1 = String[]::new;
        String[] strs2 = fn1.apply(20);
        System.out.println(strs2.length);
    }

    @Test
    public void test7() {
        Employee emp1 = new Employee("name1", 12, 14342);
        Employee emp2 = new Employee("name2", 12, 2345);
        List<Employee> emps = Arrays.asList(emp1, emp2);
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        System.out.println(emps);
    }

    public String TestLambda(String str, MyFun<String, String> mf) {
        return mf.getValue(str);
    }

    @Test
    public void test8() {
        String str = TestLambda("null", (x) -> x.toUpperCase());
        System.out.println(str);
    }

    public void cal(Long num1, Long num2, MyFunc2<Long, Long> fn) {
        System.out.println(fn.getVal(num1, num2));
    }

    @Test
    public void test9() {
        cal(10l, 20l, (x, y) -> x + y);
        cal(10l, 20l, (x, y) -> x * y);
    }
}
