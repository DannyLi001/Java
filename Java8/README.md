# Java8 新特性

- 速度更快
- 代码更少 (Lambda表达式)
- 强大的Stream API
- 便于并行
- 最大化减少空指针异常：Optional
- Nashorn引擎，允许在JVM上运行JS应用

## Lambda表达式
- Lambda是一个匿名函数，可以把它理解为是一段可以传递的代码(将代码像数据一样进行传递)。使用它可以写出更简洁，灵活的代码。作为一种更紧凑的代码风格，使Java语言表达能力得到了提升。

```java
// Lambda表达式
Runnable r2 = () -> System.out.println(“something”);
r2.run();

Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
int result = com2.compare(21,12);

//方法引用
Comparator<Integer> com3 = Integer :: compare;
result = com3.compare(21,12);
```
1. 格式
	- `->` ：Lambda操作符 或 箭头操作符
	- `->`左边：Lambda形参列表(接口中的抽象方法的形参列表)
	- `->`右边：Lambda体(重写的抽象方法的方法体)
2. Lambda表达式的使用
	- 无参，无返回值(Runnable 是接口)
		- `Runnable r2 = () -> System.out.println(“something”);`
	- 一个参数，无返回值
		- `Consumer<String> con = (x) -> System.out.println(x);`
	- 数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
	- 如果只有一个参数，可以不写括号
	- 多个参数，Lambda体有多条语句，有返回值
		- `Comparator<Integer> com = (x, y) -> {System.out.println("sth"); return Integer.compare(x, y);}`
	- 如果只有一条语句，大括号和return都可以不写
3. Lambda表达式本质
	- 需要函数式接口的支持
		- 函数式接口：接口中只有一个抽象方法的接口（使用`@FunctionalInterface`修饰）
4. 四大核心函数式接口
	- `Consumer<T>`:  `void accept(T t);`
	```java
	public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test 
    public void test11(){
        happy(1000, x -> System.out.println(x));
    }
	```
	- `Supplier<T>`: `T get();`
	```java
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
	```
	- `Function<T, R>`: `R apply(T t);`
	```java
	public String strFun(String str, Function<String, String> fn){
		return fn.apply(str);
	}

	@Test 
	public void test13(){
		String str = strFun("dksfjowi", x -> x.toUpperCase());
		System.out.println(str);
	}
	```
	- `Predicate<T>`: `boolean test(T t);`
	```java
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
	```
## 方法引用
- 若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”

三种语法格式：
1. 对象 : : 实例方法名
	```java    
	@Test 
	public void test1(){
		Consumer<String> con = (x) -> System.out.println(x);

		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;
		con1.accept("something");
	}
	```
2. 类 : : 静态方法名
	```java
	public void test3(){
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		
		Comparator<Integer> com1 = Integer::compare;
    }
	```
3. 类 : : 实例方法名
	```java
	public void test4(){
        BiPredicate<String,String> bp = (x,y) -> x.equals(y);

        BiPredicate<String,String> bp2 = String::equals;
    }
	```

- 注意：
	- Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值保持一致
	- 若Lambda参数列表中的第一参数是 实例方法的调用者，第二参数是实例方法的参数时，可以使用ClassName : : method
## 构造器引用
- 格式：
	`ClassName::new`
	```java
	public void test5(){
        Supplier<Employee> sup = () -> new Employee();
        sup.get();
        // 无参构造器
        Supplier<Employee> sup1 = Employee::new;
        // 带参构造器
        Function<String,Employee> fn1 = Employee::new;
        Employee emp = fn1.apply("name5");
        System.out.println(emp);
    }
	```
- 注意：
	需要调用的构造器的参数列表需要与函数式接口中抽象方法的参数列表保持一致
## 数组引用
- 格式：`Type::new`

	```java
	public void test6(){
		Function<Integer, String[]> fn = x -> new String[x];
		String[] strs = fn.apply(10);
		System.out.println(strs.length);

		Function<Integer, String[]> fn1 = String[]::new;
		String[] strs2 = fn1.apply(20);
		System.out.println(strs2.length);
	}
	```

## Stream API
- 集合讲的是数据，流讲的是计算
- 注意：
	1. Stream不会储存元素
	2. Stream不会改变源对象，它会返回一个持有结果的新Stream
	3. Stream操作是延迟执行的（等到需要结果时才执行）
```java
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
```
```java
// 2 中间操作
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
	// 3 终止操作：一次性执行全部内容
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

    /* 映射：
     * map - 接收Lambda，将元素转换成其他形式或提取信息，该函数会被引用刀每个元素
     * 上，并将其映射成一个新的元素
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
```
```java
// 3 终止操作

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
```
### 并行流与顺序流
在Java8中，使用parallel() 和 sequential() 还实现并行流和顺序流之间的转换。并行流的底层逻辑是 `Fork/Join` 框架。
#### Fork/Join 框架 (参考`ForkJoin.java`)
- 在必要的情况下，将一个大任务进行拆分(fork)成若干个小任务，再将一个个小任务运算的结果进行汇总(join)
- 与传统线程池的区别
	- 采取工作窃取模式
		- 将任务拆分成更小的任务执行，并将小任务加到线程队列中，从一个随机线程中偷一个并放到自己的队列中。 
```java
@Test
public void test3() {
	LongStream.rangeClosed(0, 100000000000L)
			.parallel() // 并行流
			.reduce(0, Long::sum);
}
```

## Optional 类
- Optional\<T> 类是一个容器类，代表一个值存在与否。原来用null表示一个值不存在，现在Optional可以更好的表达这个概念，避免空指针异常。
```java
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
	Optional<Employee> op = Optional.ofNullable(new Employee());
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
	Optional<Employee> op = Optional.ofNullable(new Employee());
	Optional<Integer> age = op.map(x -> x.getAge());
	System.out.println(age.get());

	Optional<String> op2 = op.flatMap(x -> Optional.of(x.getName()));
	System.out.println(op2.get());
}
```
## 接口中的默认方法与静态方法
### 默认方法
- “类优先” 原则
	- 如果一个接口中定义了一个默认方法，而另外一个父类或接口中又定义了一个同名的方法时
		- 如果父类提供了具体的实现，接口的默认方法会被忽略
		- 接口冲突。如果两个接口中的默认方法重名，需要在类中重写该方法来选择使用哪个接口中的方法或都不使用。
```java
public interface MyFun1 {
    // 默认方法
    default void getName(){
        System.out.println("interface");;
    }
}
```
### 静态方法
```java
public interface MyFun1 {
    // 静态方法
    public static void show(){
        System.out.println("static func");
    }
}
// 使用 Main中
MyFun1.show();
```
## 新时间日期API
- LocalDate、LocalTime、LocalDateTime
	- 这些的实例是不可变对象(像String) 
```java
// 1 LocalDate LocalTime LocalDateTime
@Test
public void test1() {
	LocalDateTime ldt = LocalDateTime.now();

	LocalDateTime ldt2 = LocalDateTime.of(2015, 10, 19, 13, 55, 25);

	LocalDateTime ldt3 = ldt.plusYears(2);

	LocalDateTime ldt4 = ldt.minusHours(5);

	int year = ldt.getYear();
	int dayOfMonth = ldt.getDayOfMonth();
}
```
- Instant 时间戳
```java
// 2 Instant 时间戳 Unix元年: 1970.1.1T00:00:00到某时间之间的毫秒数
@Test
public void test2() {
	Instant ins1 = Instant.now(); // 默认获取UTC时区
	OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));

	long epochMilli = ins1.toEpochMilli();
}
```
- Duration、Period
```java
   /* 3
	* Duration 计算两个“时间”之间间隔
	* Period   计算两个“日期”之间的间隔
	*/
@Test
public void test3(){
	Instant now = Instant.now();
	try {
		Thread.sleep(1000);
	} catch (Exception e) {
	}
	Instant now2 = Instant.now();
	Duration between = Duration.between(now, now2);
	System.out.println(between.toMillis());

	LocalDate now3 = LocalDate.now();
	LocalDate of = LocalDate.of(2024, 04, 01);
	Period between2 = Period.between(now3, of);
	System.out.println(between2.getDays());
}
```

- 日期操纵
	- TemporalAdjuster：时间矫正器（将日期调整到下个周日）
	- TemporalAdjusters：该类通过静态方法提供了大量常用的TemporalAdjuster的实现
```java
// TemporalAdjuster：时间矫正器
@Test
public void test4(){
	LocalDateTime now = LocalDateTime.now();
	System.out.println(now);
	
	LocalDateTime withDayOfMonth = now.withDayOfMonth(10);
	System.out.println(withDayOfMonth);

	LocalDateTime ldt  = now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
	System.out.println(ldt);

	// 自定义
	LocalDateTime ldt4 = now.with((l) -> {
		LocalDateTime ldt3 = (LocalDateTime) l;
		DayOfWeek dow = ldt3.getDayOfWeek();
		if(dow.equals(DayOfWeek.FRIDAY)){
			return ldt3.plusDays(3);
		} else if(dow.equals(DayOfWeek.SATURDAY)){
			return ldt3.plusDays(2);
		} else {
			return ldt3.plusDays(1);
		}
	});
}
```
- DateTimeFormatter 
```java
// DateTimeFormatter: 格式化时间/日期
@Test
public void test5(){
	DateTimeFormatter dtf  = DateTimeFormatter.ISO_DATE;
	LocalDateTime ldt  = LocalDateTime.now();

	String strDate  = ldt.format(dtf);

	DateTimeFormatter dtf2  = DateTimeFormatter.ofPattern("dd-MM-yyyy,ss:mm:HH");
	String strDate2  = dtf2.format(ldt);

	LocalDateTime ldt3  = LocalDateTime.parse(strDate2,dtf2);
}
```
- 时区处理 `ZonedDate、ZonedTime、ZonedDateTime`
```java
// ZonedDate、ZonedTime、ZonedDateTime
@Test
public void test6(){
	Set<String> set  = ZoneId.getAvailableZoneIds();
	LocalDateTime ldt  = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
	System.out.println(ldt);
	LocalDateTime ldt1  = LocalDateTime.now();
	ZonedDateTime zdt  = ldt1.atZone(ZoneId.of("Asia/Shanghai"));
	System.out.println(zdt);
}
```

## 可重复注解与类型注解
![可重复注解与类型注解](img\Annotation.png)
