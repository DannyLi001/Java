import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.*;

import Employee.Employee;

public class TestLambda {

    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    // Lambda 表达式
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("name1", 18, 1234),
            new Employee("name2", 19, 7645),
            new Employee("name3", 10, 5234),
            new Employee("name4", 70, 2134));

    // 原始方法
    @Test
    public void test3() {
        List<Employee> list = filterEmployees(employees);

        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

    public List<Employee> filterEmployees(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }
        return emps;
    }

    // 重写接口
    @Test
    public void test4() {
        // FilterEmployeebyAge 实现了 MyPredict接口
        // FilterEmployeebyAge 重写了 MyPredict接口 的方法
        // new FilterEmployeebyAge() 是实现了 MyPredict接口 的类 的对象
        List<Employee> emps = filterEmployees2(employees, new FilterEmployeebyAge());   
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }


    // 只要是实现了Mypredict接口的类的对象 都可以作为参数
    // <Employee> 泛型确定了接口中 抽象方法 的参数类型

    public List<Employee> filterEmployees2(List<Employee> list, MyPredict<Employee> mp) {
        List<Employee> emps = new ArrayList<>();

        // test()方法 被FilterEmployeebyAge重写过 所以调用的是FilterEmployeebyAge中的test()方法
        for (Employee emp : list) {
            if (mp.test(emp)) {
                emps.add(emp);
            }
        }
        return emps;
    }

    // 匿名内部类
    @Test
    public void test5() {
        // 可以使用匿名内部类来创建实现接口的对象。
        List<Employee> emps = filterEmployees2(employees, new MyPredict<Employee>() {
            public boolean test(Employee t) {
                return t.getAge() <= 50;
            }
        });
        // 定义test -> test 传入 filterEmployees2 -> filterEmployees2 调用 test -> 返回数据
        System.out.println(emps);

    }

    // Lambda表达式
    @Test
    public void test6() {
        // MyPredict 中 test方法 只有一个参数 -> e
        // Lambda 体 填写了需要被重写的 test方法
        // filterEmployees2 方法中 emp 就是 e
        List<Employee> list = filterEmployees2(employees, (e) -> e.getAge() <= 50);
        list.forEach(System.out::println);

    }

    // Stream API
    @Test
    public void test7() {
        employees.stream()
                .filter((e) -> e.getAge() >= 50)
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    public void test8() {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    @Test
    public void test9() {
        String str = "   asdjfoiwqef   ";
        String caps = strHandler(str, s -> s.toUpperCase());
        System.out.println(caps);
    }

    public void op(Long n1, Long n2, MyFunc2<Long, Long> mf) {
        System.out.println(mf.getVal(n1, n2));
    }

    @Test
    public void test10() {
        op(100L, 200L, (x, y) -> x + y);
        op(100L, 200L, (x, y) -> x * y);
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test 
    public void test11(){
        happy(1000, x -> System.out.println(x));
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sp){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int n = sp.get();
            list.add(n);

        }
        return list;
    }

    @Test 
    public void test12(){
        List<Integer> list = getNumList(10, () -> (int)(Math.random() * 1000));
        System.out.println(list);
    }


    public String strFun(String str, Function<String, String> fn){
        return fn.apply(str);
    }

    @Test 
    public void test13(){
        String str = strFun("dksfjowi", x -> x.toUpperCase());
        System.out.println(str);
    }

    public List<String> Fun1(List<String> list, Predicate<String> pd){
        List<String> strList = new ArrayList<>();
        for (String string : list) {
            if(pd.test(string)){
                strList.add(string);
            }
        }
        return strList;
    }

    @Test 
    public void test14(){
        List<String> list = Arrays.asList("Hij","jksdf","ALIJFOIE");
        List<String> strlist = Fun1(list, x -> x.length() > 4);
        for (String string : strlist) {
            System.out.println(string);
        }
    }

    public String func (Integer num, Function<Integer, List<Integer>> fn){
        List<Integer> list = fn.apply(num);
        String str = list + "";
        return str;
    }
    
    @Test
    public void test15(){
        System.out.println(func(5, x -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                list.add(i);
            }
            return list;
        }));
    }
    

}