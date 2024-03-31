import java.util.Optional;

import org.junit.Test;

import Employee.Employee;
import Employee.Man;
import Employee.NewMan;
import Employee.Godness;

public class TestOptional {
    /*
     * Optional 常用方法：
     * Optional.of(T t)：创建一个optional实例
     * Optional.empty(): 创建一个空的Optional实例
     * Optional.ofNullable(T t)：若t不为null，创建Optional实例，否则创建空实例
     * isPresent()：判断是否包含值
     * orElse(T t)：如果调用对象包含值，返回该值，否则返回t
     * map(Function f)：如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
     * flatMap(Function mapper)：与map类似，要求返回值必须是Optional
     */

    @Test
    public void test1() {
        Optional<Employee> op = Optional.of(null);
        Employee emp = op.get();
        System.out.println(emp);
    }

    @Test
    public void test2() {
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());
    }

    @Test
    public void test3() {
        Optional<Employee> op = Optional.ofNullable(null);
        // if (op.isPresent()) {
        // System.out.println(op.get());
        // }
        Employee emp = op.orElse(new Employee("name", 12, 1234));
        System.out.println(emp);
        // Lambda 表达式中可以填写任意功能
        op.orElseGet(() -> new Employee());
    }

    @Test
    public void test4() {
        Optional<Employee> op = Optional.ofNullable(new Employee("name"));
        Optional<Integer> age = op.map(x -> x.getAge());    // op.map 对op里面的对象进行Lambda中的操作
        System.out.println(age.get());

        Optional<String> op2 = op.flatMap(x -> Optional.of(x.getName()));
        System.out.println(op2.get());
    }

    @Test
    public void test5() {
        Man man = new Man();
        String n = getGodnessName(man);
        System.out.println(n);

        Optional<Godness> gn = Optional.ofNullable(new Godness());  // 在gn里创建了一个Godness[null]
        Optional<NewMan> op = Optional.ofNullable(new NewMan(gn));  // 将这个gn作为参数创建了一个NewMan
        String str = getGodnessName2(op);                           // NewMan -> opt.gn -> null
        System.out.println(str);
    }

    public String getGodnessName2(Optional<NewMan> man) {
        return man.orElse(new NewMan())                             // 检查man是否为null，是则创建一个NewMan，否则继续
                .getGodness()                                       // 通过上面给的NewMan来获取Godness
                .orElse(new Godness("name"))                   // 检查Godness是否为null，同上
                .getName();                                         // 通过上面给的Godness来获取Name
    }

    public String getGodnessName(Man man) {
        if (man != null) {
            Godness gn = man.getGodness();
            if (gn != null) {
                return gn.getName();
            }
        }
        return "default";
    }

}
