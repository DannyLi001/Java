# Java

## 入门

### Java特点

- Java语言是面向对象的(oop)
- Java语言是健壮的: 强类型机制, 异常处理, 垃圾的自动收集等
- Java语言是跨平台性的 (编译好的.class文件可以在多个系统下运行)
- Java语言是解释型的
  - 解释性语言: javascript, PHP, java	编译性语言:c/c++
  - 区别是: 解释性语言,编译后的代码,不能被机器直接执行,需要解释器. 编译性语言,编译后代码可以直接被执行

---

### Java运行机制与运行过程

- **JVM**(Java virtual machine) Java虚拟机
  1. JVM是虚拟计算机,具有指令集并使用不同的储存空间. 负责执行指令,管理数据,内存,寄存器. 包含在**JDK中**
  2. 不同平台有不同虚拟机
  3. 虚拟机机制屏蔽了运行平台的差别, "一次编译,到处运行"

- JDK(Java development kit) 开发工具包
  1. JDK = JRE + java开发工具(eg. javac)
  2. JDK包含JRE和开发工具, 无需重复安装JRE
- JRE(Java runtime enviroment) Java运行环境
  1. JRE = JVM + Java核心类库
  2. 如果只想运行, 安装JRE即可

#### 小结

- JDK = JRE + 开发工具集
- JRE = JVM + Java核心类库
- 如果只想运行java的.class文件, 只需JRE

---

### Hello.java

```java
// 1. 表示Hello是一个类，public公有的类
// 2. Hello{} 表示类的开始和结束
// 3. public static void main... 表示一个主方法,即程序入口
// 4. main() {} 表示方法的开始和结束
// 5. System.out.println...表示输出内容到屏幕
// 6. ;表示语句结束
public class Hello {
	//main
	public static void main(String[] args) {
		System.out.println("hello,world");
	}
}
//一个文件中可以有多个类,但只能有一个public类
//其他类会生产其他.class文件
//main可以放在非public类内 并运行该类
//文件名必须与public类名字相同
```

编译: javac 	运行: java Hello (没有.class)

### 编译过程

1. 通过编译器将源文件(.java)编译成JVM可识别的字节码文件(.class)
2. 程序没有错误则没有错误信息, 否则生产字节码文件, 也是可执行java文件

### 运行过程

1. 将.class文件装载到JVM执行
2. 修改.java文件后需要重新编译

---

### 转义字符 ChangeChar.java

```java
public class ChangeChar {
	public static void main(String[] args) {
		// \t: 一个制表位,实现对齐功能
		System.out.println("1\t2\t3");
		// \n: 换行符
		System.out.println("1\n2\n3");
		// \\: 一个\
		System.out.println("\\1\\2\\3");
		// \r: 一个回车			输出: 32
		System.out.println("12\r3");
	}
}
```

---

### 文档注释 Comment.java

注释内容可以被JDK提供的工具javadoc所解析，生成一套以网页文件形式体现的该程序的说明文档

```java
/**
 * @author Danny
 * @version 1.0
*/
public class Comment {
	public static void main(String[] args){
		//
	}
}
```

指令：`javadoc -d 文件夹 -... -... Comment.java`

### 代码规范

- 类, 方法的注释使用文档注释
- 非javadoc的注释是给代码维护者看的, 重点告诉读者为什么这么写, 如何修改, 注意什么

---

### DOS

- disk operating system 磁盘操作系统

#### 指令

- dir
- cd (cd..     cd \)
- tree
- cls
- exit
- md
- rd
- copy
- del
- echo (输入内容到文件)
- type
- move (剪切)

---

### 数据类型

- 基本数据类型	

  - 数值型 [字节数]
    - 整数
      - byte[1], short[2], int[4], long[8]
    - 浮点
      - float[4], double[8]
  - 字符
    - char[2]
  - 布尔
    - boolean[1]

- 引用数据类型

  - 类 class
  - 接口 interface

  - 数组 []

##### 注意

整数型常量(默认值)为int. 声明long型常量需后加 'l' 或者 'L'.

1byte = 8bit

浮点型常量(默认值)为double, 声明floaf后需加 'f' 或者 'F'

字节数大的不能往小的装 (eg. int a = 2L		float a = 1.1)

科学计数法: 1.1e-2

小数计算: 

```java
double a = 2.7;
double b = 8.1 / 3;
System.out.println(a); // 2.7
System.out.println(b); // 2.699999999...
// 对运算结果是小数 进行相等判定时,需注意
if (a == b) {
	...不会运行
}
// 应该
if (Math.abs(a - b) < 0.001) {
	do...
}
```

<u>为啥有时会出现 4.0 - 3.6 = 0.40000001 这种现象？</u>

- 由于浮点计算的精度问题引起. 浮点数是二进制, 无法精准表达十进制. 在浮点数计算时,会出现误差.

---

### Java API

#### Java 类的组织形式

JDK ->  包 -> 接口 / 类 / 异常 -> 字段 / 构造器(构造方法) / 成员方法 

可以通过包 -> 类 -> 方法的形式在API文档中找到相关使用方法, 或者直接搜索

### 字符类型

#### 本质

- 储存: 'a' -> 码值97 -> 二进制 -> 储存
- 读取: 二进制 -> 97 -> 'a' -> 显示

#### 编码表

1. ASCII (一个字节表示, 一共128字符, 一个字节可以表示256字符,只用了128个)
2. Unicode (固定大小的编码, 两个字节表示字符, 字母和汉字都是两个字节)
3. utf-8 (大小可变的编码, 字母一个字节, 汉字三个字节)
4. gbk (可以表示汉字, 而且范围广, 字母1字节, 汉字2字节)

---

### 基础数据类型转换 Convert.java

1. 精度小的类型自动转换为精度大的数据类型, 这就是**自动类型转换**

   - char -> int -> long -> float -> double

   - byte -> short -> int ...

2. 当多种类型数据混合计算时,系统将首先自动将所有数据转换成容量最大的数据类型, 然后计算

3. 当把精度大的数据赋值给精度小的数据时, 会报错, 反之自动转换

4. byte,short 和char之间不能相互自动转换
5. byte, short, char 三者可以计算, 但首先转换为int类型
6. boolean不参与转换 (在java中, boolean的值为true or false, 不是 0 或者 1)

```java
int n1 = 10;
// 当多种类型数据混合计算时,系统将首先自动将所有数据转换成容量最大的数据类型, 然后计算
float d1 = n1 + 1.1; // 错误 计算结果是double
double d1 = n1 + 1.1;
float d1 = n1 + 1.1F;

// 当把精度大的数据赋值给精度小的数据时, 会报错, 反之自动转换
int n2 = 1.1 // 错误

// 当把数赋给byte时,先判断数值是否在byte范围内,如果是就可以
byte b1 = 10; // 对

int n2 = 1;
byte b2 = n2; // 错误 变量赋值,判断类型

// byte,short 和char之间不能相互自动转换
char c1 = b1; // 错误

// byte, short, char 三者可以计算, 但首先转换为int类型
byte b2 = 1;
short s1 = 1;
short s2 = b2 + s1; //错误
byte b4 = b2 + b3; // 错误
```

#### 强制转换 ForceConvert.java

1. 当进行数据的大小从 大 -> 小, 就需要使用强制转换
2. 只针对最近的操作数有效
3. char可以保存int的常量值, 但不能保存int的变量值, 需强转
4. byte和short进行运算是当int处理

```java
//只针对最近的操作数有效
// int x = (int)10 * 3.5 - 5; 错误
int x = (int)(10 * 3.5 - 5);
System.out.println(x);

// char可以保存int的常量值, 但不能保存int的变量值, 需强转
char c1 = 100;
int m = 100;
// char c2 = m; // 错误
System.out.println((char)m);
```

### String和基础数据类型的转换

```java
//基本数据类型 -> String
int n1 = 100;
String s1 = n1 + "";

//String -> 基本数据类型
String s2 = "123";
int n2 = Integer.parseInt(s2);
String s3 = "12.3";
double d1 = Double.parseDouble(s3);
```

#### 注意

1. string转基本类型时, 要确保转出的有效性. 将"hello"转成整数会报错.
2. 如果格式不正确, 会抛出异常, 程序终止. 可以编译, 无法运行

---

### 运算符

```java
System.out.println(10.0 / 4); // 2.5
double d = 10 / 4; // 2.0
// %的本质，a % b = a - (int)a / b * b
System.out.println(-10 % 3); // = -1
System.out.println(10 % -3); // = 1
System.out.println(-10 % -3); // = -1
```

前++：++i先自增后赋值

后++：i++先赋值后自增

i = i++的结果是什么？为什么？

- 规则使用临时变量：`tmp = i; i = i + 1; i = tmp;`
- i = 1

i = ++i 的结果是什么？为什么？

- 规则使用临时变量：` i = i + 1; tmp = i; i = tmp;`
- i = 2

#### 逻辑运算符

```java
int a = 4; int b = 9;

// 对于&&短路与，如果第一个条件为false, 后面不在判断
if (a < 1 && ++b < 50) {
	will not do...
}
System.out.println(a + " " + b); // a = 4, b = 9

// 对于&逻辑与，如果第一个条件为false, 后面也会继续判断
if (a < 1 & ++b < 50) {
	will not do...
}
System.out.println(a + " " + b); // a = 4, b = 10
```

- 短路或 “||” 和逻辑或 “|” 同理

##### 逻辑异或 ^

- a^b，当a和b不同时，结果为true

##### 赋值运算符

复合赋值运算符会进行类型转换

```java
byte b = 3;
b += 2; // b = (byte)(b + 2)
b ++; // 同理
```

##### 三元运算符 ? :

表达式1和2要为可以赋给接收变量的类型(或可自动转换)

- eg. `int c = a > b ? 1.1: 2.4;`

#### 运算符优先级

1. (), {} 等
2. 单目运行 ++ --
3. 算数运算符
4. 位移运算符
5. 比较运算符
6. 逻辑运算符
7. 三元运算符
8. 赋值运算符

---

### 标识符命名

1. 包名: 多个单词组成时, 所有字母小写: aaa.bbb.ccc
2. 类名/接口名: 多个单词组成时, 所有单词首字母大写: XxxYyyZzz (大驼峰)
3. 变量名/方法名: 多个单词组成时, 第一个单词首字母小写, 后面单词首字母大写: xxxYyyZzz (小驼峰)
4. 常量名: 所有字母大写, 多单词用下划线链接: XXX_YYY_ZZZ

---

### 键盘输入 Input.java

```java
import java.util.Scanner; // 表示将java.util下的Scanner类导入

public class Input {
	public static void main (String[] args) {
		// 接收用户输入
		// 步骤
		// Scanner类表示 简单文本扫描器, 在java.util包
		// 1. 引入/导入 Scanner类所在的包
		// 2. 创建Scanner对象, new 创建一个对象
		// myScanner 是Scanner类的对象
		Scanner myScanner = new Scanner(System.in);

		// 3. 接收用户输入, 使用相关方法
		System.out.println("name");
		String name = myScanner.next();
		System.out.println("age");
		int age = myScanner.nextInt();
		System.out.println("salary");
		double salary = myScanner.nextDouble();

		System.out.println(name + " " + age + " " + salary);
	}
}
```

接收字符: `char c1 = myScanner.next().charAt(0);`

### 位运算

- 按位取反
- 按位与
- 按位或
- 按位异或

#### 原码/反码/补码

1. 0表示正数,1表示负数
2. 正数原码/反码/补码一样
3. 负数反码 = 原码符号位不变,其他取反
4. 负数补码 = 它的反码 +1, 负数反码 = 负数补码 - 1
   - -2原码: 1000 0010
   - -2反码: 1111 1101
   - -2补码: 1111 1110
5. 0的反码补码都是0
6. java中的数都是有符号的
7. 计算机运算时, 都以<u>补码方式来运算</u>
8. 看运算结果时, 看原码

---

### if-else IfElse.java

`if (a = false)`可以编译成功, 并且将a赋值为false. if中的判断也为false

### switch

```java
switch(表达式) {
	case 常量1:
		...
		break;
	case 常量2:
		...
		break;
	...
	default:
		...
		break;(optional)
}
```

switch 是一个关键字

退出switch需要使用break.

如果没有break, 直接执行下一个case里的代码. (穿透)

#### 注意

- 表达数据类型需要和case常量类型一致, 或者是可以自动转换成相互比较的类型 (eg. 输入是字符, 常量是int)
- 表达式中的返回值必须是: byte, short, int, char, enum[枚举], String
- case子句中的值必须是常量,不能是变量
- default是optional, 没有default且没有匹配case, 不进行任何执行
- break用来跳出switch, 如果没有, 将执行之后的case直到break或结尾

#### switch or if

1. 如果判断的具体条件不多, 且符合byte, short, in, char, enum, String 建议使用switch
2. 对区间判断, 对结果为boolean类型判断, 使用if

### For循环

`for(... ; ... ; ...)`

- 初始化和变量迭代可以写在别的地方, 但两边分号不能省略

- `for(;;)`无限循环
- 可以有多个初始化和多个迭代语句

---

### break 跳转控制 BreakDetail.java

- break语句出现多层嵌套的语句块中时, 可以通过标签指明要终止的是哪一层语句块

  ```java
  label1:{...
  label2:		{...
  label3: 		{...
  					break label2;
  				}
  			}
  		}
  ```

### equals

- 用来比较字符串的内容

```java
name.equals("Danny");
"Danny".equals(name); //推荐 可以避免空指针
```

<u>== 和 equals 比较的区别</u>

1. ==用来判断两边是不是指向同一个内存地址, equals用来判断两边所指的内存空间的值是否相同
2. ==是运算符号, equals是一个方法
3. ==比equals运行速度快, 因为==只是比较引用

---

### continue 跳转控制

- 类似与break的跳转控制

```java
public class BreakDetail {
	public static void main(String[] args) {
		label1:
		for(int j = 0; j < 4; j++){
			label2:
				for(int i = 0; i < 10; i++){
					if(i == 2){
						continue label1;
					}
					System.out.println(i); // 01 01 01 01
				}
		}
	}
}
```

---

### 数组

eg. `int[] nums = {1, 2, 3, 4};`(静态初始化)

`String strs[] = new String[]{"a","b","c"};`

创建空数组: `int nums[] = new int[需要大小];`

#### 动态初始化

`int[] a`

`a = new int[3]`

#### 注意

- 数组里的内容是否可以自动转换为数组的类型
- 数组中的元素可以是任何数据类型, 包括引用类型
- 数组创建后, 默认值为0, false, String null 
- 数组属引用类型, 数组型数据是对象

```java
int[] arr1 = {1, 2, 3};
int[] arr2 = arr1;
arr2[0] = 0; // arr1 = {0, 2, 3}
```

数组在默认情况下是引用传递, 赋的值是地址, 赋值方式是引用赋值

#### 引用传递 vs 值传递

基本类型数据, 在jvm内存中, 放在栈

数组在栈中储存的是地址, 该数组的元素储存在堆里的相应地址里

#### 数组拷贝

`int[] arr1 = {1,2,3};`

`int[] arr2 = new int[arr1.length]`

然后对arr1遍历, 赋值到arr2

#### 数组反转

```java
int[] arr1 = {1,2,3,4,5,6,7,8,9};
for(int i = 0; i < arr1.length / 2; i++){
    tmp = arr1[i];
    arr1[i] = arr1[arr1.length - 1 - i];
    arr1[arr1.length - 1 - i] = tmp;
}
```

#### 数组扩容

```java
int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
int[] arr2 = new int[arr1.length + 1];
for(int i = 0; i < arr1.length; i++) {
    arr2[i] = arr1[i];
}
arr2[arr2.length - 1] = 8;
arr1 = arr2;
```

#### 数组缩减

```java
int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
int[] arr2 = new int[arr1.length - 1];
for(int i = 0; i < arr2.length; i++) {
    arr2[i] = arr1[i];
}
arr1 = arr2;
```

---

### 排序

#### 内部排序

将需要处理的所有数据加载到内部储存其中进行排序

#### 外部排序

数据量过大, 无法全部加载到内存中, 需要借助外部储存进行排序

#### 冒泡排序

```java
for(int i = arr1.length - 1; i > 1; i--) {
    for(int j = 0; j < i - 1; j++) {
        if(arr1[j] > arr1[j + 1]){
            int tmp = arr1[j];
            arr1[j] = arr1[j + 1];
            arr1[j + 1] = tmp;
        }
    }
}
```

### 查找

- 顺序查找

```java
String[] names = {"123","456","789"};
String find = myScanner.next();
int index = -1;
for(int i = 0; i < names.length; i++) {
	if(names[i].equals(find)){
        do ... // 找到了
        index = 1;
        break;
    }
}
if(index == -1){
    //没找到
}
```

- 二分查找

### 二维数组

`int[][] arr = {{0,0,0,0,0},{1,1,1,1,1},{2,2,2,2,2}};`

#### 动态初始化

`int[][] arr1 = new int[2][3];`

#### 内存分布 YangHuiTri.java

类似于数组的jvm内存分布, 栈中储存的是arr1在堆中的地址, 不同点是在堆中的arr1相应地址储存的是接下来每一列的地址(eg. arr1[0]的地址), 通过这些地址可以在堆中找到每一列的元素.

![二维数组内存中存在形式](.\img\2Dlist_JVM_Show.jpg)

```java
int[][] arr1 = new int[3][];
for(int i = 0; i < arr1.length; i++) {
    arr[i] = new int[i+1];
    ... // 赋值
}
```

#### 练习

```
int[] x,y[];

x[0] = y; // 错误 int[][] -> int[]
y[0] = x; // 正确 int[] -> int[]
y[0][0] = x; // 错误 int[] -> int
x[0][0] = y; // 错误 无法访问x[0][0]
y[0][0] = x[0]; // 正确 int -> int
x = y; // 错误 int[][] -> int[]
```

---

### 类与对象 OOP Object.java

解决问题:

1. 单独变量? 不利于数据管理
2. 数组? 数据类型体现不出来, 下标与内容关系不明确, 不能体现类的行为

对象是类下面的具体个例: 如猫为类, 但是花猫为一个猫的对象

```java
// main
Cat cat1 = new Cat();
cat1.name = "miao";
cat1.age = 3;

class Cat {
    // 属性/成员变量
    // 也可以为引用数据类型
	String name;
	int age;
	char[] color;
	double weight;
}
```

#### 对象的存在形式

创建对象后, 对象的变量名在栈中指向一个地址, 相同地址在堆中储存对象的数据, 如果数据为基础类型数组, 则储存在堆中对象地址下, 如果为引用类型, 则堆中储存一个方法区地址, 该地址在方法区的常量池中. 在常量池相同地址里储存引用类型数据.

在创建对象的时候, 类的信息会加载到方法区

![对象在内存中存在形式](.\img\Object_JVM_Show.jpg)

如果只是声明的话, 不会分配空间 `Cat cat;`

#### Java内存结构分析 (创建对象流程)

- 栈: 一般存放基本数据类型(局部变量)

- 堆: 存放对象

- 方法区: 常量池 (常量, 比如字符串), 类加载信息

1. 先加载Cat类信息 (属性和方法信息只会加载一次)
2. 在堆中分配空间, 进行默认初始化
3.  把地址赋给cat, cat就指向对象
4. 进行指定初始化, 比如 cat.age = 12;

#### 类的成员方法

成员方法的创建:

```java
// main
Person p1 = new Person();
p1.speak();

class Person {
	String name;
	int age;

	// speak 方法名 	() 形参列表
	public int speak(int i, int j) {
		System.out.println(i + j);
        return i + j;
	}
}
```

##### 方法的调用机制

![成员方法在内存中的形式](.\img\OOPMethod_JVM_Show.jpg)

创建对象如之前的对象在JVM内存的存在形式一样, 当执行到成员方法时, 会在栈中自动开辟一个独立空间. 这个空间运行成员方法中的指令. 当返回主函数后, 该独立空间会被释放. (主函数同理 第5点)

##### 方法使用细节

1. 如果想要返回多个返回值，使用数组返回
2. 返回类型可以为任何类型
3. 如果有返回数据类型，必须要有return + 值，而且两者的类型一直或兼容
4. 使用驼峰命名法(getSum)
5. 方法体里不能再定义方法

```java
class A {
	public void f1() {
		public void f2()... //错误
    }
}
```

6. 同一类中的方法调用：直接调用即可

```java
class B{
	public void f1(){}
	public void f2(){
		f1();
	}
}
```

7. 跨类中的方法A类调用B类方法：需要通过创建对象调用

```java
class A {
	public void f1(){}
}
class B {
	public void f2(){
		A tmp = new A();
		tmp.f1();
	}
}
```

8. 跨类的方法调用和访问修饰符相关

#### 克隆对象 CopyObj.java

```java
class Person {
	String name;
	int age;
}
class Tool {
	public Person copy(Person p) {
		Person newp = new Person();
		newp.name = p.name;
		newp.age = p.age;
		return newp;
	}
}
```

### 递归执行机制

![递归在内存中的形式](.\img\Recursion_JVM_Show.jpg)

每次递归将会开辟一个新的栈空间，知道递归判定失效. 每层递归结束后会返回到上层递归并执行之后指令。

#### 注意

1. 执行一个方法时，就创建一个新的受保护的独立空间
2. 方法局部变量是独立的
3. 如果使用的是引用类型变量，会共享引用类型数据
4. 递归必须向退出递归的条件逼近，否则会死循环
5. 当一个方法执行完毕，返回到调用他的方法

#### 斐波那契数 RecursionFibonacciSeq.java

```java
public int cal(int i) {
    if (i < 1){
        return 0;
    } else {
        if(i == 1 || i == 2) {
            return 1;
        } else {
            return cal(i - 1) + cal(i - 2);
        }
    }
}
```

### 方法重载

允许同一类中，多个同名方法的存在，但要求形参表不一致

```java
class MyCal {
    public int calculate(int n1, int n2){...}
    public double calculate(int n1, double n2){...}
    public double calculate(double n1, int n2){...}
    public int calculate(int n1, int n2, int n3){...}
}
```

#### 注意

- 方法名：必须相同

- 形参列表：必须不同 (形参类型或个数或顺序, 至少有一种不同, 参数名无要求)

- 返回类型: 无要求 (只是返回类型不同, 不会构成重载)

### 可变参数

允许将同一类中多个同名同功能但参数个数不同的方法, 封装成一个方法

```java
class VarParameter {
	public int sum(int... nums) {	// nums可以当作数组操作
		int res = 0;
		for(int i = 0; i < nums.length; i++) {
			res += nums[i];
		}
		return res;
	}
}
```

#### 注意

- 可变参数的实参可以为数组	`v1.sum({1,2,3});`
- 可变参数可以和普通类型的参数一起放在形参列表, 但必须保证可变参数在最后
  - `public void f2(String str, double n1, double... nums);`

- 一个形参列表中只能出现一个可变参数
  - 错误: `public void f2(String... str, double... nums);`

### 作用域

- 主要的变量就是属性和局部变量
  - 局部变量一般是指成员方法中定义的变量 (Cat类: cry)
- 作用域的分类:
  - 全局变量: 也就是属性, 作用域为整个类体 如Cat类: cry eat 等方法使用属性
  - 局部变量: 也就是除了属性之外的其他变量, 作用域为定义它的的代码块中
- 全局变量可以不赋值, 直接使用, 因为有默认值, 局部变量必须赋值后, 才能使用

```java
class Cat{
    int num1; // 可以 默认为0
	public void f1(){
		int num2;
		System.out.println(num2); // 无法编译 必须赋值;
	}
}
```

#### 注意

- 属性和局部变量可以重名, 访问时遵循就近原则
  - 成员方法中有定义相同变量名时, 方法内使用该变量值
- 属性可以加修饰符, 局部变量不可以

### 构造器 Constructor.java

主要作用是完成堆新对象的初始化

1. 方法名和类名一致
2. 没有返回值
3. 创建对象时, 系统自动调用该类的构造器完成初始化

```java
// main
Person p1 = new Person("name", 12);

class Person {
    String name;
    int age;
    // 构造器没有返回值, 也不能写void
    // 其他与成员方法一样
    public Person(String pName, int pAge){
        name = pName;
        age = pAge;
    }
}
```

#### 注意

1. 一个类可以定义多个不同的构造器, 即构造器重载
2. 无法像成员方法一样在主程序调用构造器, 构造器为系统自动调用
3. 可以用javap 反编译 .class -> .java
4. 不写构造器, 系统会使用默认的无参构造器 (默认: Dog(){})

#### 对象创建流程方向 JVM内存

1. 在方法区加载类信息
2. 在堆中开辟空间, 并进行默认初始化 (0 或 null)
3. 根据类中的定义赋值
4. 再根据构造器获取内容, 对上一步的值进行修改 (完成初始化)
5. 最后再将堆中的地址传到栈

### This关键字

虚拟机会给每个对象分配this，代表当前对象

```java
class Person{
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}
```

#### This 在JVM中的体现

![This在内存中的形式](.\img\This_JVM_Show.jpg)

- 可以使用 `dog1.hashCode()` 和 `this.hashCode()` 去检查两个对象在虚拟机里的地址是相同的
  - hashCode() 是对地址进行哈希之后得到的整数, 并不是地址本身

#### 注意

1. This可以访问属性, 方法, 构造器
2. 访问成员方法的语法:`this.方法名(参数列表);`
3. 访问构造器语法: `this(参数列表)`
   - 只能在构造器中使用 (**只能在构造器中访问另一个构造器**)
   - 访问构造器语法: `this(参数列表)` **必须放置在第一条语句**

```java
class T{
    public T(){
        this("name",100);
        ...
    }
    public T(String name, int age){...}
}
```

只写 `new Test()` 为匿名对象, 使用后就不能使用

### IDEA IDE快捷键

- ctrl + y：删除当前这行
- ctrl + d：复制当前这行
- ctrl + alt + l：自动对齐
- .var: 自动补全对象创建
- alt + insert: 生成构造器
- ctrl + H: 查看光标所指类的继承关系

### 包

- 区分相同名字的类
- 当类很多时，可以很好的管理类
- 控制访问范围

#### 基本语法

`package com.hspedu;`

1. package 关键字, 表示打包
2. com.hspedu 包名

#### 包的本质

实际上就是创建不同的文件夹来保存类文件

![包的本质](.\img\Package_Show.jpg)

#### 包的命名

规则:

- 只能包含数字, 字母, 下划线, 小圆点., 但不能用数字开头, 不能是关键字或保留字

规范:

- 小写字母 + 小圆点
- com.公司名.项目名.业务模块名

#### 常用的包

- java.lang.* (基本包, 默认引入)
- java.util.* (系统提供的工具包)
- java.net.* (网络包, 网络开发)
- java.awt.* (做页面开发, GUI)

#### 注意

```java
// 建议只导入需要的类
//import java.util.Scanner; // 引入java.util 包下的Scanner
//import java.util.*; // 将java.util 包下的所有类都引入

// package 用来声明当前类所在的包, 需要放在最上面
// 一个类中最多一句package
package com.hspedu.pkg;

//import 位置放在package下面, 类定义前面, 多个import没有顺序要求
import java.util.Scanner;
```

### 访问修饰符

四种访问控制修饰符号, 用于控制方法和属性的访问权限

1. 公开级别: public
2. 受保护级别: protected, 对子类和同一个包中的类开放
3. 默认级别: 没有修饰符号, 向同一个包的类开放
4. 私有级别: private, 只对类本身可以访问, 不对外公开

| 访问级别 | 访问控制修饰符 | 同类 | 同包 | 子类 | 不同包 |
| -------- | -------------- | ---- | ---- | ---- | ------ |
| 公开     | public         | ✔    | ✔    | ✔    | ✔      |
| 受保护   | protected      | ✔    | ✔    | ✔    | ❌      |
| 默认     | N/A            | ✔    | ✔    | ❌    | ❌      |
| 私有     | private        | ✔    | ❌    | ❌    | ❌      |

#### 注意

1. 修饰符可以用来修饰类中的属性, 成员方法以及类

2. 只有默认和public才能修饰类! 
3. 成员方法的访问规则和属性一样

### 封装 encapsulation

把抽象出的数据(属性)和对数据的操作(方法)封装在一起, 数据被保护在内部, 程序的其他部分只能通过被授权的操作(方法)才能对数据进行操作

#### 好处

- 隐藏实现细节
- 可以对数据进行验证, 保证安全合理

#### 实现步骤 com.hspedu.encap: Encapsulation01.java

1. 将属性私有化 private
2. 提供一个公共的set方法, 用于对属性判断并赋值
3. 提供一个公共的get方法, 用于获取属性的值

```java
class Person {
    public String name;
    private int age;
    private double sal;
	
	public setName(String name){...}
    public getName(){...}
	...
}
```

#### 封装与构造器结合

```java
public Person(String name, int age, double sal) {
    setName(name);
    setAge(age);
    setSal(sal);
}
```

### 继承

解决代码复用

![继承的本质](.\img\Inheritance_Show.jpg)

- 父类也叫超类

```java
public class Graduate extends Student{}
```

#### 注意

1. 子类继承了所有属性和方法, 但私有属性和方法不能在子类直接访问, 要通过公共的方法访问
2. 子类必须调用父类的构造器, 完成父类的初始化 (**先构造父类再构造子类**)
3. 创建子类对象时, 不管使用子类哪个构造器, 默认情况下会去调用父类的无参构造器, 如果父类没有提供无参构造器, 则必须在子类的**构造器**中用`super()`去指定使用父类哪个构造器完成对父类的初始化, 否则编译不会通过.

```java
// 当父类有指定构造器:
public Student(int age, double score) {
    this.age = age;
    this.score = score;
}
// 子类的构造器中指定
public class Pupil extends Student{
    public Pupil(int age, double score) {
        super(age, score);
    }
}
```

4. 使用`super(参数列表)`去指定父类构造器
5. `super`在使用的时候, 必须放在构造器的第一行
6. `super()` 和 `this()` 都只能放在构造器第一行, 因此两个方法不能共存在一个构造器中
7. 所有类都是Object类的子类, Object是所有类的基类
8. 父类构造器的调用不限于直接父类, 将一直追溯到Object类
   - 人话: 子类会先调用父类构造器, 知道调用到Object类
9. 子类最多只能继承一个父类 (直接继承), **单继承机制**
10. 子类和父类之间必须满足 is-a 的逻辑关系

#### 继承的本质分析

![继承在JVM中的体现](.\img\Inheritance_JVM_Show.jpg)

注意:

- 访问属性时, 按就近原则 (访问age -> 39, 访问hobby -> 旅游)
- 如果按就近原则访问到的属性为private, 则编译报错
- 如果没有找到, 则提示方法不存在

```java
class A{
	A(){print("a");}
	A(String name){print("a name");}
}
class B extends A{
	B(){this("abc"); print("b");}
	B(String name){print("b name");}
}
// main
B b = new B(); // 输出: a, b name, b
```

### super 关键字

super代表父类的引用, 用于访问父类的属性, 方法, 构造器

```java
public class A {
	public int n1;
	protected int n2;
	int n3;
	private int n4;
	
	public void f1(){}
}
class B extends A{
    public B(){
        super(); // super调用父类构造器
    }
	void print(){
		super.f1(); // super调用父类方法
		print(super.n1); // super调用父类属性(除了n4都可以)
	}
}
```

1. 调用父类的构造器的好处 - 分工明确, 父类属性由父类初始化, 子类属性由子类初始化
2. 当子类中有和父类中的成员(属性和方法) 重名时, 访问父类的成员需要加通过`super`. 如果没有重名, super, this, 直接访问效果一样

3. super的访问不限于直接父类, 根据就近原则可以访问到多个基类(上级类)

| 区别点     | this                               | super                                  |
| ---------- | ---------------------------------- | -------------------------------------- |
| 访问属性   | 访问本类中属性, 没有往父类找       | 从父类开始查找属性                     |
| 调用方法   | 访问本类中方法, 没有往父类找       | 从父类开始查找方法                     |
| 调用构造器 | 调用本类构造器, 必须放在构造器首行 | 调用父类构造器, 必须放在子类构造器首行 |
| 特殊       | 表示当前对象                       | 子类中访问父类对象                     |

### 方法重写

子类有和父类相同名字，返回类型，参数的方法，那么这个方法覆盖了父类的方法

```java
public class Animal {
    public void cry(){
        print("1");
    }
}
class Dog {
    public void cry(){	// Dog的cry方法重写了Animal的cry方法
        print("2");
    }
}
```

#### 注意

- 子类方法的参数，方法名，要和父类方法的一样
- 子类方法的返回类型要和父类的一样，或者是父类返回类型的子类
- 子类方法不能缩小父类方法的访问权限  // 父类public void f1 -> 子类protected void f1错误❌

#### 重载和重写

|      名称      | 发生范围 |  方法名  |            形参列表            |                  返回类型                  |               修饰符               |
| :------------: | :------: | :------: | :----------------------------: | :----------------------------------------: | :--------------------------------: |
| 重载 overload  |   本类   | 必须一样 | 类型, 个数或顺序至少有一个不同 |                   无要求                   |               无要求               |
| 重写 overwrite |  父子类  | 必须一样 |              相同              | 返回的类型和父类的返回类型一致或者是其子类 | 子类方法不能缩小父类方法的访问范围 |

### 多态 FeedProblem.java

方法或对象具有多种形态, 多态是建立在封装和继承基础上的

#### 具体体现

- 方法的多态 
  - 重写和重载就体现多态
- 对象的多态 (核心)
  - 一个对象的编译类型和运行类型可以不一致
  - 编译类型在定义对象时,就确定了, 不能改变
  - 运行类型可以改变，可以通过getClass()查看运行类型
  - 编译类型看定义时 = 号左边, 运行类型看 = 号右边

```java
Animal animal = new Dog(); // animal编译类型是Animal, 运行类型是Dog
animal = new Cat(); // animal的运行类型编程了Cat 编译类型还是Animal
```

#### 注意

- 多态前提: 两个对象存在继承关系
- 多态的**向上转型**
  - 本质: 父类的引用指向了子类的对象 `Animal animal = new Dog()`
  - 特点: 
    - 编译类型看左边, 运行类型看右边
    - 可以调用父类中的所有成员(需遵守访问权限)
    - 不能调用子类中特有成员
      - 因为在编译阶段, 能调用哪些成员是由编译器决定
      - `animal.子类中独有的方法()` 错误
    - 最终运行效果看子类(运行类型)的具体实现, 即就近原则

#### 向下转型

1. 只能强转父类的引用, 不能强转父类的对象
2. 要求父类的引用必须指向的是当前目标类型对象
3. 当向下转型后, 可以调用子类类型的成员

```java
Animal animal = new Dog(); 
animal = new Cat(); 
Cat cat = (Cat) animal; //强转
cat.子类中独有的方法();
```

#### 注意 Cont.

- 属性没有重写之说! 属性的只看编译类型

```java
//main
Base base = new Sub();
base.count; // count = 10

class Base{
    int count = 10;
}
class Sub extends Base {
    int count = 20;
}
```

- **instanceOf 比较操作符** 用于判断对象的运行类型是否为XX类型或者XX类型的子类型

```java
// main
BB bb = new BB();
bb instanceof BB; // true
bb instanceof AA; // true

AA aa = new BB();
aa instanceof AA; // true
aa instanceof AA; // true

class AA{}
class BB extends AA{}
```

#### 动态绑定机制 重要

1. 当调用对象方法的时候，该方法会和该对象的内存地址/运行类型绑定
2. 当调用对象属性时, 没有动态绑定机制, 哪里有声明, 哪里使用

人话: 

- 编译类型是父类, 运行类型是子类
- 运行的时候, 先从子类中找方法, 如果找到就使用
- 如果没找到, 并在父类中找到, 父类的方法中如果调用了子类里重写的别的方法, 那么就会运行子类中重写的方法.

```java
//main
A a = new B();
System.out.println(a.sum()); // 30
System.out.println(a.sum1()); // 30

class A {
    int i = 10;
    public int sum(){
        return getI() + 10; // 这里的getI()调用的是子类中的方法
    }
    public int sum1() {
        return i + 10; 
    }
    public int getI(){
        return i;
    }
}
class B extends A {
    int i = 20;
    
    public int getI(){
        return i; 
    }
    public int sum1() {
        return i + 10; // 这里的i是20, 属性没有动态绑定机制
    }
}
```

#### 多态数组 PolyArray.java

数组的定义类型为父类类型, 里面保存的实际元素类型为子类类型

- 可以用instanceof去检查多态数组中每个元素的类型, 然后使用向下转型去分别访问子类中的独有方法

### == 运算符

== 和 equals 比较的区别?

- == 是一个比较运算符
  - 可以判断基本类型, 又可以判断引用类型
  - 如果是基本类型, 判断的是 值 是否相等
  - 如果是引入类型, 判断的是 地址 是否相等, 即判断是不是一个对象

### equals 方法

- equals只能判断引用类型
- Obeject的equals方法默认是比较两个对象地址是否相等

```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

```java
String str1 = new String("123");
String str2 = new String("123");
// String 的equals重写过
str1 == str2; // false
str1.equals(str2); // true
```

#### 重写equals

```java
public boolean equals(Object obj){ // 这里的参数要是Object类
    if(this == obj){
        return true;
    }
    if(obj instanceof Person){
        Person person = (Person) obj;
        return name.equals(person.name) && age == person.age &&
               sex == person.sex;
    }
    return false;
}
```

`"hello" == new java.sql.Date(); //编译报错` 

### hashCode

- 提高具有哈希结构的容器效率
- 两个引用, 如果指向的是同一个对象, 哈希值肯定一样
- 两个引用, 如果指向的是不同对象, 哈希值不一样
- 哈希值主要根据地址号来, 不能完全将哈希值等价于地址
- 在集合中, 如果需要, hashCode会重写

### toString

打印对象信息

重写可使用快捷键

```java
public String toString() { // 重写
    return "Monster{" +
            "name='" + name + '\'' +
            ", job='" + job + '\'' +
            ", sal=" + sal +
            '}';
}
com.hspedu.object.Monster@b4c966a // 为重写前输出
System.out.println(monster1); // 可以直接打印对象
```

### finalize

- 当对象被回收时, 系统自动调用该对象的finalize方法, 子类可以重写该方法, 做一些释放资源的操作
- 当某个对象没有任何引用时, jvm会认为这个对象是个垃圾对象, 就会使用垃圾回收机制来销毁对象, 在销毁前, 会调用finalize方法
- 垃圾回收机制的调用由系统决定, 也可以通过`System.gc()`主动触发
  - 实际开发中不会使用, 应付面试

### 断点调试

- 调试过程中是运行状态, 对象是运行类型来执行
- 查看jdk原码需要force step in，或者进行配置

### 类变量

也叫静态变量, 是该类的所有对象共享的一个变量, 任何一个该类的对象去访问时, 得到的是同一个值, 同样, 任何对象去修改它时, 修改的也是同一个变量

#### 类变量的内存分布

- Java8以前, 类变量储存在方法区里的静态域里, 之后的版本放在堆中的Class类里
- 不管在哪, static变量是同一个类所有的对象共享
  - static类变量, 在类加载的时候就生成了

![类变量在JVM中的体现](.\img\Static_JVM_Show.jpg)

#### 注意

1. 当我们需要让某个类的所有对象都共享一个变量时，就可以考虑使用类变量
2. 类变量是该类所有对象共享的，实例变量是每个对象独有的
3. 可以通过`类名.类变量`来访问
4. 类变量是类加载时就初始化了, 可以不创建对象就使用类变量
5. 类方法中无法使用和对象有关的关键字`this`和`super`
6. 类方法只能访问静态变量或静态方法
7. 普通成员可以访问静态和非静态成员

```java
// main
Student.pay(100);
Student name1 = new Student("name1");
name1.pay(200);
Student.show();

class Student {
    private String name;
    private static double fee = 0;

    public Student(String name) {
        this.name = name;
    }
    //静态方法
    public static void pay(double fee) {
        Student.fee += fee;
    }
    public static void show(){
        System.out.println(Student.fee);
    }
}
```

#### 使用场景

如果希望不创建实例, 也可以调用某个方法. 把方法做成静态方法非常合适

### main方法

1. main方法是虚拟机调用
2. 虚拟机需要调用类的main方法, 所以该方法的访问权限必须是public
3. 虚拟机在执行main方法时不必创建对象, 所以必须是main方法必须是静态方法
4. String[] args是java命令时传递给所有运行的类的参数
   - `java 运行程序 参数1 参数2...`(eg. DOS控制台中)

- 在main方法中, 可以直接调用main方法所在类的静态方法和静态属性
- 但是不能直接访问该类中的非静态方法, 需要创建一个该类的对象, 然后通过对象去访问非静态方法

### 代码块

也叫初始化块, 属于类中的成员, 类似于方法, 将逻辑语句封装在方法体中, 通过{}包围起来. 不同点是没有方法名, 没有返回, 没有参数, 只有方法体. 而且不通过对象或类显示调用, 而是加载时, 或创建对象时隐藏调用

```java
class Movie {
    private String name;
    private double price;
    private String director;
    // 下面的所有构造器有相同的语句
    // 这样代码会冗余
    // 我们把相同的语句放到代码块中
    // 不管调用哪个构造器创建对象, 都会先执行代码块的内容
    // 代码块的优先级高于构造器
    {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
    }
    // 构造器s...
}
```

#### 注意

- 修饰符(可选) 只能写static
- 语句可以为任何逻辑语句
- ;可以写上, 也可以省略

1. static代码块的作用是对类进行初始化, 它随着**类的加载**而执行, 且只会执行一次. 而普通代码块每创建一个对象就会执行
2. 类什么时候被加载 **重要**
   1. 创建对象实例 (new)
   2. 创建子类对象实例, 父类也会被加载
   3. 使用类的静态成员时 (静态属性, 静态方法)

3. 普通代码块, 在创建对象实例时, 会被隐式调用. 被创建一次, 就会调用一次. 如果**只是使用类的静态成员时, 普通代码块不会执行**
4. 创建对象时, 在一个类调用顺序是: **重点**
   1. 调用静态代码块和静态属性初始化 (如果有多个静态代码块和多个静态变量初始化, 则按顺序)
   2. 调用普通代码块和普通属性的初始化 (如有多个, 按顺序)
   3. 调用构造器

```java
// main
A a = new A();

class A {
    public A(){
		print("constructor");
    }
    {
        print("code block 1")
    }
	private static int n1 = getN1();		// 1. getN1
	static {								// 2. static code block 1
		print("static code block 1");		// 3. code block 1
	}										// 4. constructor
	public static int getN1(){
		print("getN1");
		return 100;
	}
}
```

5. 构造器的最前面隐藏了super()和 调用普通代码块. 静态相关的代码块, 属性初始化, 在类加载时就执行完毕, 所有优先级高于构造器和普通代码块
6. 创建一个子类对象时, 他们的静态代码块, 静态属性初始化, 普通代码块, 普通属性初始化, 构造方法的调用如下:
   1. 父类的静态代码块和静态属性
   2. 子类的静态代码块和静态属性
   3. 父类的普通代码块和普通属性初始化
   4. 父类的构造方法
   5. 子类的普通代码块和普通属性初始化
   6. 子类的构造方法

7. 静态代码块只能直接调用静态成员, 普通代码块可以调用任意成员

### 单例模式 (饿汉式和懒汉式)

1. 采用一定的方法保证在整个软件系统中, 对某个类只能存在一个对象实例, 并且该类只提供一个取得其对象实例的方法
   1. 饿汉式
   2. 懒汉式

- 饿汉式和懒汉式的实现
  - 构造器私有化 -> 防止用户new
  - 类的内部创建对象
  - 向外暴露一个静态的公共方法

```java
// 饿汉式
class GirlFriend{
    private String name;
    private static GirlFriend name1 = new GirlFriend("name1");
    // 如何保证只能创建一个对象 饿汉式
    // 1. 将构造器私有化
    // 2. 在类内部直接创建
    // 3. 提供一个公共的static方法, 返回GirlFriend对象
    private GirlFriend(String name) {
        this.name = name;
    }

    public static GirlFriend getInstance(){
        return name1;
    }
}
```

```java
// 懒汉式
class Cat {
    private String name;
    private static Cat cat;
    // 1. 构造器私有化
    // 2. 定义一个static静态属性对象
    // 3. 提供一个public的static方法, 可以返回一个Cat对象
    // 4. 懒汉式 只有当用户使用getInstance时, 才会返回对象, 后面再次调用, 返回上次创建的
    //		Cat对象从而保证了单例
    private Cat(String name) {
        this.name = name;
    }
    public static Cat getInstance(){
        if(cat == null) {
            cat = new Cat("cat1");
        }
        return cat;
    }
}
```

- 饿汉式 vs 懒汉式
  - 主要区别在于创建对象的时机不同, 饿汉式是在类加载时就创建了对象实例, 懒汉式时在使用时才创建
  - 饿汉式不存在线程安全问题, 懒汉式存在
  - 饿汉式存在浪费资源的可能, 因为如果一个对象实例都没有使用, 饿汉式创建的对象就浪费了, 懒汉式是使用时才创建, 不存在这个问题

---

### final 关键字

- 不希望类被继承时, 使用final修饰类
- 不希望父类某个方法被子类覆盖, 使用final修饰方法
- 不希望类的某个属性的值被修改, 用final修饰
- 不希望某个局部变量被修改, 用final修饰

#### 注意

1. final修饰的属性叫常量, 一般用XXX_XXX来命名
2. final修饰的属性在定义时, 必须赋初值, 且以后不能修改, 赋值可以在如下位置之一
   1. 定义时
   2. 构造器中
   3. 代码块中
3. 如果final修饰的属性是静态的, 则初始化的位置只能是
   1. 定义时
   2. 在静态代码块, 不能在构造器中
4. final类不能继承, 但是可以实例化对象
5. 如果类不是final类, 但含有final方法, 则该方法虽然不能重写, 但可以被继承
6. 一般来说, 如果一个类已经是final类了, 就没必要再将方法修饰成final方法
7. final不能修饰构造方法
8. final和static搭配使用, 效率更高, 不会导致类加载 (编译器优化)
9. 包装类(Integer, Double, Float等都是final类), String也是final类

### 抽象类

当父类的一些方法不确定时，可以用abstract关键字来修饰该方法，这个方法就是抽象方法，用abstract来修饰该类就是抽象类

```java
abstract class Animal{
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public abstract void eat();
}
```

1. 抽象方法没有方法体
2. 抽象类的价值更多作用是在于设计，是设计者设计好后，让子类继承并实现抽象类

#### 注意

1. 抽象类不能被实例化
2. 抽象类不一定包含abstract方法
3. 一旦一个类包含了abstract方法，则这个类必须声明为抽象类
4. abstract只能修饰类和方法，不能修饰属性和其他的
5. 抽象类可以有任意成员 (抽象类本质还是类) 比如：非抽象方法，构造器，静态属性等
6. 如果一个类继承了抽象类，则它必须实现抽象类的所有方法，除非它自己也声明为抽象类
7. 抽象方法不能使用private、final和static来修饰，因为这些关键字都是和重写相违背的

### 模板设计模式

1. 定义一个父类，该父类为抽象类
2. 父类中的抽象方法是子类需要继承的
3. 运用动态绑定机制，使子类重写父类中的抽象方法并被调用

这减少了一定量的代码重复性

### 接口

接口就是给出一些没有实现的方法，封装到一起，到某个类要使用的时候，在根据具体情况把这些方法写出来

```java
interface 接口名{
    //属性
    //方法 (1.抽象方法 2.默认实现方法 3.静态方法)
}
class 类名 implements 接口{
    //自己的属性
    //自己的方法
    //必须实现的接口的抽象方法
}
```

#### 注意

1. 接口不能被实例化
2. 接口中所有的方法是public方法, 接口中抽象方法, 可以不用abstract修饰
3. 一个普通类实现接口时，必须将该接口所有方法都实现
4. 抽象类去实现接口时，可以不实现接口的抽象方法
5. 一个类可以同时实现多个接口
6. 接口中的属性只能是final的，而且是public static final修饰符
7. 接口中属性的访问形式：接口名.属性名
8. 接口不能继承其他的类, 但是可以继承多个别的接口
   - `interface A extends B,C{}`
9. 接口的默认修饰符只能是public和默认, 这点和类的修饰符是一样的

### 接口 vs 继承

- 解决的问题不同
  - 继承的价值: 解决代码的复用性和可维护性
  - 接口的价值: 设计好规范, 让其它类去实现这些方法
- 接口比继承更加灵活
  - 继承是满足is-a的关系, 接口只需满足like-a的关系
- 接口在一定程度上实现代码解耦 [即 接口规范性+动态绑定]

### 接口的多态特性

1. 多态参数
   - 接口可以当作参数传入形参列表, 接口引用可以指向任何实现了接口的类的对象
2. 多态数组
   - 和继承相似 (父类数组可以包含子类元素)
   - 可以通过向下转型使用指定类的方法 (instanceof)

3. 接口的多态传递

```java
// main
A a = new Teacher();
B b = new Teacher();
// 如果B继承了A接口, 而Teacher类实现了B接口
// 那么, 实际上相当于Teacher类也实现了A接口
// 接口多态传递
interface A {}
interface B extends A {}
class Teacher implements B{}
```

### 内部类

一个类的内部又完整的嵌套了另一个类结构. 被嵌套的类称为内部类, 嵌套其他类的类称为外部类.内部类最大的特点就是可以直接访问私有属性, 并且可以体现类与类之间的包含关系 **[类的五大成员: 属性, 方法, 构造器, 代码块, 内部类]**

```java
class Outher{
    class Inner{}
}
class Other{}
```

#### 内部类分类

- 定义在外部类局部位置上:
  - 局部内部类 (有类名)
  - 匿名内部类 (没有类型, **重点**)
- 定义在外部类的成员的位置下:
  - 成员内部类 (没有static)
  - 静态内部类 (有static)

#### 局部内部类

局部内部类的定义在外部类的局部位置, 比如方法中, 且有类名

1. 可以直接访问外部类的所有成员, 包含私有的
2. 不能添加访问修饰符,因为它的地位就是一个局部变量. 但是可以使用final
3. 作用域: 仅仅在定义它的方法或代码块中
4. 局部内部类 *---访问---->* 外部类的成员 [直接访问]
5. 外部类 *----访问--->* 局部内部类的成员 [创建对象 再访问]

```java
class Outer02 {
    private int n1;
    private void m2(){}
    public void m1(){
        // 1. 局部内部类是定义在外部类的局部位置，通常在方法
        // 3. 不能添加访问修饰符, 但是可以使用final修饰
        // 4. 作用域: 仅仅在定义它的方法或代码块中
        final class Inner02 { // 局部内部类
            // 2. 可以直接访问外部类的所有成员, 包含私有的
            public void f1(){
                // 5. 局部内部类可以直接访问外部类的成员
                System.out.println(n1);
                m2();
            }
        }
        // 6. 外部类的方法中, 可以通过创建对象去调用内部类的方法
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}
```

6. 外部其他类 ----不能访问----> 局部内部类
7. 如果外部类和局部内部类的成员重名时, 默认遵循就近原则, 如果想访问外部类的成员, 则可以使用 (`外部类名.this.成员`) 访问

#### 匿名内部类

- 本质是类
- 内部类
- 该类没有名字
- 同时还是一个对象

匿名内部类是定义再外部类的局部位置, 比如方法中, 并且没有类名

```java
class OuterClass{ // 外部类
    private int n1;
    public void method(){
        // 基于接口的匿名内部类
        // 1. 需求: 想使用接口, 并创建对象
        // 2. 传统方式: 写一个类, 实现该接口, 并创建对象
        // 3. Tiger类只使用一次, 后面不再使用
        // 4. 可以使用匿名内部类来简化开发
        // 5. tiger的编译类型是A接口
        // 6. tiger的运行类型是匿名内部类 该类是由系统内部创建
        // 底层内部结构
        /*
            class OuterClass$1 implements A{}
         */
        // 7. jdk底层再创建匿名内部类 OuterClass$1, 立即就创建了实例, 并把地址放回给了tiger
        // 8. 匿名内部类使用一次就不能再使用了
        A tiger = new A() { // 匿名内部类 基于接口
            @Override
            public void cry() {
                System.out.println("tiger cry");
            }
        };
        tiger.cry();

        // 1. father编译类型 Father
        // 2. father运行类型 匿名内部类 OuterClass$2
        // 3. 底层内部结构
        /*
            class OuterClass$2 extends Father{}
         */
        // 4. 同时也返回了 匿名内部类 OuterClass$2 对象
        // 5. 参数列表会传递给构造器
        Father father = new Father("name1"){ // 匿名内部类 基于类
            @Override
            public void test() {
                System.out.println("new test");
            }
        };
        father.test();
    }
}

interface A { // 接口
    public void cry();
}

class Father { // 类
    public Father(String name) {}
    public void test(){}
}
```

##### 注意

1. 匿名内部类即是一个类的定义, 也是一个对象. 它既有定义类的特征, 也有创建对象的特征
2. 可以直接访问外部类的所有成员, 包含私有的
3. 不能添加访问修饰符,因为它的地位就是一个局部变量
4. 作用域: 仅仅在定义它的方法或代码块中
5. 匿名内部类 *---访问---->* 外部类的成员 [直接访问]
6. 外部其他类 *----不能访问--->* 匿名内部类的成员
7. 如果外部类和匿名内部类的成员重名时, 默认遵循就近原则, 如果想访问外部类的成员, 则可以使用 (`外部类名.this.成员`) 访问

#### 成员内部类

成员内部类是定义在内部类的成员位置, 并且没有static修饰

1. 可以直接访问外部类的所有成员, 包括私有的
2. 可以添加任意访问修饰符, 应为它的地位是一个成员

```java
class Outer{
    public class Inner01{}
}
```

3. 作用域: 和外部类的其他成员一样, 为整个类体: 在外部类的成员方法中创建成员内部类对象, 在调用
4. 成员内部类 *---访问--->* 外部类 [直接访问]
5. 外部类 *---访问--->* 成员内部类 [创建对象再访问]
6. 外部其他类 *---访问--->* 成员内部类
7. 如果外部类和成员内部类的成员重名时, 默认遵循就近原则, 如果想访问外部类的成员, 则可以使用 (`外部类名.this.成员`) 访问

#### 静态内部类

静态内部类是定义在外部类的成员位置, 并且有static修饰

1. 可以直接访问外部类的所有静态成员, 包含私有的, 但不能直接访问非静态成员
2. 可以添加任意访问修饰符
3. 作用域: 同其他的成员, 为整个类体
4. 静态内部类 ---访问---> 外部类 (比如:静态属性) [直接访问所有静态属性]
5. 外部类 ---访问---> 静态内部类 [创建对象, 再访问]
6. 外部其他类 ---访问---> 静态内部类
7. 如果外部类和静态内部类的成员重名时, 默认遵循就近原则, 如果想访问外部类的成员, 则可以使用 (`外部类名.成员`) 访问

### 枚举

- 枚举是一组常量的集合
- 属于一种特殊的类，里面只包含一组有限的特定的对象

1. 自定义枚举

```java
class Season{
    private String name;
    private String desc;
    // 1. 将构造器私有化
    // 2. 去掉Setter
    // 3. 在内部直接创建对象
    // 4. 优化 加入final修饰符
    public static Season SEASON1 = new Season("season1", "desc1");
    public static Season SEASON2 = new Season("season2", "desc2");
    public static Season SEASON3 = new Season("season3", "desc3");
    public static Season SEASON4 = new Season("season4", "desc4");
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
```

- 对枚举对象使用`final static` 共同修饰, 实现底层优化 (无需加载类方法)
- 枚举对象名通常使用全部大写

2. enum关键字

```java
enum Season0 {
    // 如果使用enum来实现枚举
    // 1. 关键字enum代替class
    // 2. 创建方法: 常量名(实参列表)
    // 3. 如果有多个常量(对象) 使用, 号间隔
    // 4. 如果使用enum, 要求将定义常量对象写在前面
    SEASON1("season1", "desc1"),
    SEASON2("season2", "desc2"),
    SEASON3("season3", "desc3"),
    SEASON4("season4", "desc4");
    private String name;
    private String desc;


    private Season0(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
```

1. 使用enum关键字开发枚举时, 默认会继承Enum类, 而且是一个final类
2. 简写`常量名(实参列表)` 这里必须知道用的是哪个构造器
3. 如果使用无参构造器创建枚举, 实参列表和小括号都可以省略

#### enum常用方法

1. name: 返回当前对象名, 子类中不能重写
2. ordinal: 返回当前对象的位置号, 默认从0开始
3. values: 返回当前枚举类中所有的常量
4. valueOf: 将字符串转换成枚举对象, 要求字符串必须为已有的常量名, 否则报错
5. compareTo: 比较两个枚举常量, 比较的是编号

#### 注意

1. 使用enum关键字后, 就不能继承其他类, 因为enum隐式继承Enum
2. enum实现的枚举类, 可以实现接口

### 注解

1. 也被称为元数据, 用于修饰解释 包, 类, 方法, 属性, 构造器, 局部变量等数据信息
2. 和注释一样, 不影响程序逻辑, 但注解可以被编译或运行, 相当于嵌入在代码中的补充信息
3. javaSE的注解用于标记过时的功能, 忽略警告. javaEE的注解用于配置应用程序的任何切面

注解Annotation前面增加@符号, 并把该annotation当成一个修饰符使用. 用于修饰它支持的程序元素

1. @Override: 限定于方法, 重写父类方法
2. @Dprecated: 表示某个程序元素已过时
3. @SuppressWarnings: 抑制编译器警告

#### @Override

- @Override注解源码为: `@Target(ElementType.METHOD)` @Target是修饰注解的注解

#### @Deprecated

- 即不推荐使用, 但任然可以使用
- 可以修饰方法, 类, 字段, 包, 参数 等
- 可以做版本升级过度使用

#### @SuppressWarning

- 可以通过@SuppressWarning来抑制警告信息
- 在{""}中, 可以写入想要抑制(不显示)的警告信息

`@SuppressWarining({"all"})`

- 作用范围是和放置的位置有关

### 异常处理机制

程序执行中发生的不正常情况叫"异常"

- 主要分两类
  - Error(错误): JVM无法解决的严重错误
    - JVM系统内部错误
    - 资源耗尽
  - Exception
    - 编程错误或偶然的外在因素导致的一般性问题
    - 空指针访问
    - 读取不存在文件
    - 分为两大类
      - 运行时异常
      - 编译时异常

#### 异常体系图

![异常体系图](.\img\Throwable_Show.jpg)

##### NullPointerException空指针异常

- 需要对象的地方使用null时, 抛出异常

##### ArithmeticException 数学运算异常

- 当出现异常的运算条件时, 抛出异常

##### ArrayIndexOutOfBoundsException 数组下标越界异常

- 如果索引为负或大于等于数组大小, 抛出异常

##### ClassCastException 类型转换异常

- 试图将对象强转为不是实例的子类, 抛出异常

##### NumberFormatException 数字格式不正确异常

- 试图将字符串转成数值类型, 但字符串不符合格式时, 抛出异常

#### 异常处理方式

1. try-catch-finally
   - 程序员捕获发生的异常并处理

```java
try{
    // 可能有问题的代码
} catch (Exception e){
    // 捕获到的异常
    // 1. 只有捕获到异常才运行
    // 2. 将异常封装成Exception对象e
    // 3. 得到异常后,程序员自己处理
} finally{
    // 不管有没有异常, 始终执行finally
}
```

2. throws

   将发生的异常抛出, 交给调用者来处理, JVM时最顶级的处理者

   1. try-catch-finally 和 throws二选一
   2. throws后面的异常类型可以是方法中发生的异常, 也可以是它的父类
   3. throws关键字后也可以是异常列表, 即抛出多个异常

##### 注意 (try-catch)

1. 如果异常发生, 则异常发生后面的代码不会执行, 直接进入catch
2. 如果没有异常发生, 不会进入catch
3. 如果希望不管是否发生异常, 都执行某段代码, 使用finally
4. 可以有多个catch语句, 捕获不同的异常. 要求父类异常在后, 子类在前.
5. 可以进行`try-finally`配合使用, 相当于没有捕获异常. 因此程序会崩溃

##### 注意(throws)

1. 对于编译异常, 程序必须处理 try-catch 或 throws
2. 对于运行异常, 程序中如果没有处理, 默认为throws
3. 子类重写父类方法时, 要和父类抛出异常一致, 要么为父类抛出异常的类型子类

#### 自定义异常

- 自定义异常类名 继承Exception或RuntimeException
- 继承Exception属于编译异常
- 继承RuntimeException属于运行异常

```java
public static void main(String[] args) {
    int age = 900;
    if(!(age >= 18 && age <= 120)){
        throw new AgeException("something");
    }
}
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}
```

一般继承RuntimeException, 如果定义为Exception那么调用throws

#### throw vs throws

|        | 意义                     | 位置       | 后面跟的东西 |
| ------ | ------------------------ | ---------- | ------------ |
| throws | 异常处理的一种方式       | 方法声明处 | 异常类型     |
| throw  | 手动生成异常对象的关键字 | 方法体中   | 异常对象     |

```java
try {
    if(args.length != 2){
        throw new ArrayIndexOutOfBoundsException("something0");
    }
    int n1 = Integer.parseInt(args[0]);
    int n2 = Integer.parseInt(args[1]);
    double result = cal(n1, n2);
    System.out.println(result);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println(e.getMessage());
} catch (NumberFormatException e){
    System.out.println("something1");
} catch (ArithmeticException e){
    System.out.println("something2");
}
```

### 包装类

正对八种基本数据类型相应的引用类型——包装类

| 基本数据类型 | 包装类    |
| ------------ | --------- |
| boolean      | Boolean   |
| char         | Character |
| byte         | Byte      |
| short        | Short     |
| int          | Integer   |
| long         | Long      |
| float        | Float     |
| double       | Double    |

![包装类体系图](.\img\Wapper_Show.jpg)

#### 装箱 和 拆箱

装箱: 基本类型 -> 包装类型, 反之 拆箱

```java
public static void main(String[] args) {
    // 手动装箱
    int n1 = 100;
    Integer integer = new Integer(n1);
    Integer integer1 = Integer.valueOf(n1);
    // 手动拆箱
    int i = integer.intValue();

    // jdk5.0后 自动装箱和自动拆箱
    int n2 = 200;
    // jdk5.0后 自动装箱 int -> Integer
    Integer integer2 = n2; // 底层使用Integer.valueOf(n2);
    // 自动拆箱
    int n3 = integer2; // 底层integer.intValue();
}
```

其他类新一样

#### 包装类 int -> string

```java
Integer i2 = 100;
String str1 = i + "";
String str2 = i2.toString();
String str3 = String.valueOf(n2);
```

#### 包装类 String -> int

```java
String str4 = "1234";
Integer i3 = Integer.parseInt(str4);
Integer i4 = new Integer(str4);
```

#### 注意

```java
public static void main(String[] args) {
    Integer i = new Integer(1);
    Integer j = new Integer(1);
    System.out.println(i == j); // F	比较的是两个对象的地址

    Integer m = 1;
    Integer n = 1;
    System.out.println(m == n); // T	底层代码 Integer.valueOf()

    Integer x = 128;
    Integer y = 128;
    System.out.println(x == y); // F	底层代码 Integer.valueOf(128)
}								//		如果超过-128~127, 则直接返回对象
```

- 如果对比中有基本数据类型, 那么直接比较值 `128 == new Integer(128);`True

#### String 类

- String对象用于保存字符串, 一组字符序列
- 字符串常量用双引号括起来的字符序列: "name"
- 使用Unicode字符编码, 中文英文都占两个字节
- String有很多构造器
- 实现了两个接口: *Serializable*(串行化: 可以在网络传输)和*Comparable*(比较大小)
- Stirng是final类, 不能被继承
- String有属性 private final char value[]; 用于存放字符串
- value是一个final类型, 不可以修改(地址)
  - 这里说的是被创建那个字符串的地址是不可以修改的, 但是String的指向是可以改变的

##### String对象创建方式

- String s = "name";
- String s2 = new String("name");

![String的JVM内存图](.\img\String_JVM_Show.jpg)

#### StringBuffer

1. 直接父类是AbstractStringBuilder
2. 实现了Serialization
3. 父类中char[] value不是final, 该value存放字符串内容, 存放在堆中 不是常量池
4. final类, 不能被继承

##### String vs StringBuffer

- String保存的是字符串常量, 不能被修改 `private final char value[]`
- StringBuffer保存的是字符串变量, 每次更新不用更新地址, 效率更高

##### String转换StringBuffer

```java
String str = "string";
StringBuffer stringBuffer = new StringBuffer(str);

String s = stringBuffer.toString();
```

#### StringBuilder

- 可变的字符序列
- 兼容StringBuffer的API
- 不保证同步
- 被设计做为StringBuffer的一个简易替代, 用在字符串缓冲区被单个线程使用的时候

1. 直接父类是AbstractStringBuilder
2. 实现了Serialization
3. 父类中char[] value不是final, 该value存放字符串内容, 存放在堆中 不是常量池
4. final类, 不能被继承
5. StringBuilder没有做互斥处理, 即没有synchronized关键字, 只有在单线程下使用StringBuilder

##### StringBuilder vs StringBuffer vs String

1. StringBuilder和StringBuffer非常类似, 均代表可变的字符序列, 方法也一样
2. String: 不可变字符序列, 效率低, 但是复用性高
3. StringBuffer: 可变字符序列, 效率较高, 线程安全
4. StringBuilder: 可变字符序列, 效率最高, 线程不安全

所以: 如果我们对String做大量修改, 不要使用String

- 大量操作用StringBuffer或StringBuilder
- 大量操作, 单线程, 用StringBuilder
- 大量操作, 多线程, 用StringBuffer
- 少量修改, 被多个对象引用, 用String

5. StringBuffer和StringBuilder底层默认构建长度为16的数组

6. StringBuffer和StringBuilder当字符串长度大于底层存放字符的数组的长度时就会触发扩容机制(扩容为原来的2倍+2)

#### Arrays

Arrays里面包含了一系列静态方法, 用于管理或操作数组

- toString 返回数组的字符串形式

- sort排序(自然排序或定制排序)

  - 通过传入一个比较器实现定制排序

  ```java
  Arrays.sort(arr, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
          return o1 - o2;
      }
  });
  ```

- binarySearch 通过二分搜索进行查找, 要求必须排好序

- copyOf 从arr中拷贝指定数量的元素

- fill 用指定的数填充数组中所有元素

- eqauls 检查连个数组是否完全一样

- asList 把形参列表中的数转换成一个List集合

### 集合

- 可以动态保存任意多个对象
- 提供了一系列增删改查代码
- 添加或删除元素变简洁了

![Collection集合](.\img\Collection_Show.jpg)

集合主要分两种：

- 单列集合
  - Collection接口有两个重要的子接口 List 和 Set，他们的实现子类
- 双列集合
  - Map接口的实现子类

#### Collection

- 可以存放多个元素，每个元素可以是Object
- 有些实现类可以存放重复元素，有些不可以
- 有些实现类是有序的(List), 有些不是(Set)
- Collection接口没有直接的实现子类, 都是通过子接口Set和List来实现

##### 迭代器 Iterator

- 用于遍历Collection集合中的元素
- 实现了Collection接口的集合类都有iterator() 方法, 用以返回一个实现了迭代器接口的对象, 即可以返回一个迭代器
- 迭代器的结构
- 仅用于遍历集合, 迭代器本身并不存放对象

```java
// 遍历集合
// 1. 先得到迭代器
Iterator iterator = arrayList.iterator();
// itit 快捷键
// 2. 使用while循环遍历
while (iterator.hasNext()) {
    Object next = iterator.next();
}
// 3. 当退出while循环, iterator指向最后一个元素
// 4. 如果希望再次遍历, 需要重置迭代器
iterator = arrayList.iterator();
```

##### 增强for

```java
// 增强for底层依旧是迭代器
for(Object book : arrayList){
    System.out.println(book);
}
```

#### List

1. List集合类中元素有序(添加顺序和取出顺序一致)，且可以重复
2. List和集中的每个元素都有对应的顺序索引

##### ArrayList (可加null, 默认10, 1.5倍, 不安全, 效率高)

- 可以加入null
- 由数组来实现数据储存
- 基本等同于Vector, 除了ArrayList是线程不安全但效率高

###### ArrayList底层操作机制

1. ArrayList中维护了一个Object类型的数组
   - `transient Object[] elementData` // transient关键字表示该属性不会被序列化
2. 有无参构造器和有参构造器, 每次扩容都是当前容量的1.5倍, 无参构造器初始容量为0, 第一次添加后扩容10. 有参构造器初始容量为指定大小

##### Vector (可加null, 默认10, 2倍, 安全, 效率低)

- Vector底层也是一个对象数组, `protected Object[] elementData;`
- 线程同步的, 线程安全, 类方法都带有synchronized

|           | 底层结构 | 版本    | 线程安全       | 扩容倍数          |
| --------- | -------- | ------- | -------------- | ----------------- |
| ArrayList | 可变数组 | jdk 1.2 | 不安全, 效率高 | 1.5倍, 无参默认10 |
| Vector    | 可变数组 | jdk 1.0 | 安全, 效率不高 | 2倍, 无参默认10   |

##### LinkedList (可加null, 不安全, 效率高)

- 底层实现了双向列表和双端队列特点
- 可以添加任意元素, 包括null
- 线程不安全

|            | 底层结构 | 增删效率           | 查找效率 |
| ---------- | -------- | ------------------ | -------- |
| ArrayList  | 可变数组 | 较低, 数组扩容     | 较高     |
| LinkedList | 双向列表 | 较高, 通过链表追加 | 较低     |

如何选择?

1. 改查操作多 选ArrayList
2. 增删操作多 选LinkedList
3. 大部分情况选择ArrayList

#### Set

- 无序，没有索引
- 不允许重复元素, 所以最多包含一个null
- 可以使用迭代器和增强for

##### HashSet (可加null, 默认16, 复杂, 不安全, 无序)

- HashSet实现了Set接口
- HashSet实际上是HashMap

###### 底层逻辑

1. 添加一个元素时, 先得到hash值 *--转成-->* 索引值
2. 第一次添加时, table数组扩容到16, 临界值(threshold)是16*加载因子(0.75)
3. 找到储存数据表table, 看这个索引位置是否有已经存放的元素
4. 如果没有, 直接加入
5. 如果有, 调用equals比较 (可以重写), 如果相同, 就放弃添加, 如果不同, 则添加到最后
6. 如果table数组使用到了临界值, 就会扩容到16*2, 新临界值32\*0.75
7. 如果一条链表的元素个数达到8, 并且table大小 >= 64, 就会进行树化 (红黑树)
8. 如果一条链表的元素个数达到8, 并且table大小 < 64, 就会扩容

```java
HashSet hashSet = new HashSet();
Person p1 = new Person(1001, "AA");
Person p2 = new Person(1002, "BB");

hashSet.add(p1);
hashSet.add(p2);
p1.setName("CC");
System.out.println(hashSet.remove(p1));	// 删除p1 需要计算p1的新hash值, 和添加时的hash值不一样 所以删除失败
System.out.println(hashSet);	// 两个
hashSet.add(new Person(1001,"CC"));	// 与之前的无关, 添加成功
System.out.println(hashSet);	// 三个
hashSet.add(new Person(1001,"AA"));	// 添加的hash值和之前的一样, 但是现在value不一样 所以添加成功
System.out.println(hashSet);	// 四个
```

##### LinkedHashSet (有序)

- LinkedHashSet是HashSet的子类
- 底层是一个LinkedHashMap, 底层维护了一个 数组+双向链表
- LinkedHashSet根据元素的hashCode值来决定元素的储存位置, 同时使用链表维护元素的次序, 这使得元素看起来是以插入顺序保存的
- LinkedHashSet不允许添加重复元素

###### 底层逻辑

1. LinkedHashSet底层维护了一个hash表和双向链表
2. 有head和tail
3. 每一个节点有pre和next属性
4. 在添加一个元素时, 先求hash值, 再求索引, 确认该元素在hashtable的位置, 然后将添加的元素加入到双向链表
5. 遍历LinkedHashSet也能确保插入顺序和遍历顺序一致

##### TreeSet

1. 底层就是TreeMap

#### Map

![Map](.\img\Map_Show.jpg)

1. 保存具有映射关系的数据: key-value
2. map中的key和value可以为任意引用类型数据
3. key不可以重复
4. value可以重复
5. 当有相同的k, 就等价于替换
6. 常用String类作为Map的key
7. 一对k-v是放在一个HashMap$Node中的, 有 因为Node实现了 Entry接口

##### HashMap (可加null, 默认16, 复杂, 不安全, 无序)

- Map接口使用频率最高的实现类
- 可以储存null
- 和HashSet一样, 不保证映射顺序, 因为底层是hash表方式来储存
- HashMap没有实现同步, 线程不安全

###### 扩容机制

和hashSet一样

##### HashTable (不可加null, 默认11, 2倍+1, 安全, 无序)

- 使用方法基本和HashMap一样
- 线程安全
- key和value**不能为null**, 会抛出错误

###### 底层逻辑

1. 底层有数组 Hashtable$Entry[], 初始化为11
2. 临界值threshold 8 = 11*0.75
3. 扩容: *2 +1

|           | 版本 | 线程安全 | 效率 | 允许null键null值 |
| --------- | ---- | -------- | ---- | ---------------- |
| HashMap   | 1.2  | 不安全   | 高   | 可以             |
| Hashtable | 1.0  | 安全     | 较低 | 不可以           |

##### Properties

- 和Hashtable类似
- 可以从.properties文件中加载数据到Properties类对象, 并进行修改

##### TreeMap (不可加null, 不安全, 自定义)

通过在构造器中重写比较器进行排序. 如果比较器的结果为0, 就表明两个键的值相等, 所以不会替换键的值. 但是会替换值的值. 如果不写匿名内部类且要加自定义类的话需要实现comparable接口的comparaTo方法.

```java
TreeMap treeMap = new TreeMap(new Comparator() {
    @Override
    public int compare(Object o1, Object o2) {
        return ((String) o1).length() - ((String) o2).length();
    }
});
// 二选一
class Person implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
```

#### 如何选择?

1. 判断存储类型 (一组对象[单例]或一组键值对[双列])
2. 一组对象:
   - 允许重复: List
     - 增删多: LinkedList [底层维护了一个双向列表]
     - 改查多: ArrayList [底层维护了Object类型的可变数组]
   - 不允许重复: Set
     - 无序: HashSet [底层是HashMap, 维护了一个哈希表(即数组+链表+红黑树)]
     - 排序: TreeSet
     - 插入和取出顺序一致: LinkedHashSet, 维护数组+双向链表
3. 一组键值对: Map
   - 键无序: HashMap [底层是哈希表]
   - 键排序: TreeMap
   - 键插入和取出顺序一致: LinkedHashMap
   - 读取文件: Properties

### 泛型

- 编译时, 检查添加元素类型, 提高安全性
- 减少了类型转换的操作, 提高效率
- 不再提示编译警告

1. 又称参数化类型,  解决数据类型的安全问题
2. 在类声明或实例化时, 只要指定好需要的具体的类型即可
3. 使用泛型可以保证如果程序在编译时没有发出警告, 运行时就不会产生ClassCastException异常, 同时代码更加简洁, 健壮
4. 可以在类声明时通过一个标识表示类中某个属性的类型, 或者是某个方法的返回值的类型, 或者是参数类型

```java
class Person<E> {	// 自定义泛型类
	E s;	// E 表示s的数据类型, 该数据类型在定义Person对象的时候指定, 即在编译期间, 就确定E是什么类型
	public Person(E s){
		this.s = s;
	}
	
	public <T> f(T t){	// 自定义泛型方法
		return s;	
	}
}

interface InterfaceA<E> {	// 自定义泛型接口
    
}
```

#### 注意

1. 泛型指向的类型不能是基础类型, 必须是引用类型
2. 指定泛型具体类型后, 可以传入该类型或者该类型的子类型
3. 泛型使用形式

```java
ArrayList<Integer> arrayList = new ArrayList<Integer>();    // 类
List<Integer> list = new ArrayList<Integer>();      // 接口

ArrayList<Integer> arrayList1 = new ArrayList</*省略且推荐*/>();
List<Integer> list1 = new ArrayList<>();
// 如果没有<> 那么默认为Object类
```

4. 普通成员可以使用泛型 (属性, 方法)
5. 使用泛型的数组不能被初始化 // 不能确定开辟的空间大小
6. 静态方法中不能使用类的泛型 // 静态是和类相关的, 在类加载时, 对象还没创建
7. 泛型接口的类型, 在继承接口或实现接口时确定
8. 泛型方法可以定义在普通类中, 也可以在泛型类中.
9. 泛型不具有继承性 `List <Object> list = new ArrayList<String> (); //错误`
10. <?> 表示任意的泛型类型都可以接受
11. <? extends AA> 表示上限, 可以接受AA或者AA子类
12. <? super AA> 表示下限, 可以接受AA或者AA父类

### JUnit

```java
@Test	// 需要安装
public void m1(){
    System.out.println("m1");
}
```

### Java绘图

- 坐标原点位于左上角, 以像素为单位. 第一个是x坐标, 表示当前位置为水平方向, 距离坐标原点x个像素. y轴同理
- Component类提供了两个和绘图相关的重要方法:
  - paint(Graphics g) 绘制组件的外观
  - repaint()刷新组件外观
- 当组件第一次在屏幕显示的时候, 程序会自动调用paint()方法来绘制组件
  - 窗口最简化, 再最大化
  - 窗口大小发生变化
  - repaint方法被调用

### 事件处理机制

- java事件处理是采取"委派事件模型". 当事件发生时, 产生时间的对象, 会把"信息"传递给"事件的监听者"处理. 这里所说的"信息"实际上就是java.awt.event事件类库里的某个类所创建的对象, 把它称为"事件的对象"

1. 事件源: 产生事件的对象, 比如按钮
2. 事件: 事件就是承载事件源状态改变时的对象, 比如当键盘事件, 会产生一个事件对象, 该对象保存着当前时间很多信息, 比如KeyEvent对象有含有按下键的Code值. java.awt.event包和java.swing.event包中定义了各种事件类型
3. 事件监听接口:
   1. 当事件源产生一个事件, 可以传送给监听者处理
   2. 事件监听者实际上是一个类, 该类实现了某个事件监听接口
   3. 事件监听接口有多种, 不同的事件监听接口可以监听不同的事件, 一个类可以实现多个监听接口

### 线程

- 线程由进程创建, 是进程的一个实体
- 一个进程可以有多个线程

- **进程**

  - 进程指的是运行中的程序, 操作系统自动为其分配内存空间

  - 进程是程序的一次执行过程, 或者是正在运行的一个程序. 是动态过程: 它有自己的生产, 存在和消亡的过程

1. 单线程
   - 同一个时刻, 只允许一个线程

2. 多线程
   - 同一时刻, 可执行多个线程, 比如: 一个qq进程, 可以同时打开多个聊天窗口

3. 并发
   - 同一时刻, 多个任务交替执行, 造成一种"貌似同时"的错觉
     - 单核cpu实现的多任务
4. 并行
   - 同一时刻, 多个任务同时执行
     - 多核cpu可以实现并行

#### 创建线程的两种方式

1. 继承Thread类, 重写run方法
2. 实现Runnable接口, 重写run方式

```java
// 继承Thread类, 重写run方法
public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();	// 使用start启动线程
        // cat.run(); 这样运行会是在同一个线程, 不会开启新线程
    }
}
// 当一个类继承了Thread类, 该类就可以当作线程使用
// Thread类实现了Runnable接口的run方法
class Cat extends Thread{
    int count;
    @Override
    public void run() { // 重写run方法, 写上自己的业务逻辑
        while (true) {
            System.out.println("sth");
            count ++;
            try {
                Thread.sleep(1000);	// 睡眠1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 8){
                break;
            }
        }
    }
}
```

在运行过程中, 可以通过在终端输入jconsole来查看线程

- start()调用的是底层的start0()本地方法, 是JVM调用, 底层用C/C++实现

```java
// 继承Runnable, 重写run方法
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // dog 不能直接调用run
        // 代理模式
        // 创建了Thread对象, 把dog对象(实现Runnable), 放入Thread
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable{	// 推荐
    int count = 0;
    @Override
    public void run() {
        while(true){
            count++;
            System.out.println("Dog" + Thread.currentThread().getName());
            if(count == 10){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

可以出现main线程结束, 但是其他线程依然存在的情况

#### 继承Thread vs 实现Runnable接口的区别

- 从设计来看, 没有区别. 底层都是调用start()方法
- 实现Runnable接口方式更适合多个线程共享一个资源的情况, 并且避免了单继承的限制

#### 线程终止

- 当线程完成任务后, 会自动退出
- 还可以通过使用变量来控制run方法退出的方式停止线程, 即通知方式

```java
// main
T t = new T();
t.start();
// main线程控制t线程
// 修改loop, 让t退出run方法 -> 通知方式
Thread.sleep(1000 * 10);
t.setLoop(false);

class T extends Thread {
    private int count;
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
    @Override
    public void run() {
        while (loop) {...}
    }
}
```

#### 注意

1. start底层会创建新的线程, 调用run, run就是一个简单的方法调用, 不会启动新线程
2. 线程优先级的范围
3. interrupt, 中断线程, 但并没有真正的结束线程, 所以一般用于中断正在休眠线程
4. sleep: 线程的静态方法, 使当前线程休眠
5. yield: 线程的礼让, 让出cpu, 让其他线程执行, 但礼让的时间不确定, 所以比一定礼让成功
6. join: 线程的插队, 插队的现场一旦插队成功, 则肯定先执行完插入的线程所有的任务

#### 用户现场和守护线程 

`thread.setDaemon(true);`

1. 用户线程
   - 也叫工作线程, 当线程的任务执行完或通知方式结束
2. 守护线程
   - 一般是为工作线程服务的, 当所有的用户线程结束, 守护线程自动结束
3. 常见的守护线程: 垃圾回收机制

#### 线程7大状态

![7大线程状态](.\img\Thread_Type.jpg)

#### 线程同步机制 Synchronized

- 保证数据在任何一时刻, 最多有一个线程访问, 以保证数据的完整性

`public synchronized void sell()`

#### 互斥锁

- 每个对象都对应一个可称为"互斥锁"的标记, 这个标记用来保证在任一时刻, 只能有一个线程访问该对象
- 关键字synchronized来与对象的互斥锁联系, 当某个对象用synchronized修饰时, 表明该对象在任一时刻只能由一个线程访问
- 同步的局限性: 导致程序的执行效率降低
- 同步方法(非静态的)的锁可以是this, 也可以是其他对象(要求是同一个对象)
- 同步方法(静态的)的锁为当前类本身

```java
public /*synchronized*/ void sell() {
    synchronized (this) {
        if (ticketNum <= 0) {
            System.out.println("finish");
            loop = false;
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + ticketNum--);
    }
}
```

##### 注意

1. 同步方法如果没有static修饰: 默认锁对象为this
2. 如果方法使用static修饰, 默认锁对象时当前类.class
3. 实现步骤:
   1. 需要先分析上锁的代码
   2. 选择同步代码块或同步方法
   3. 要求多个线程的锁对象为同一个

#### 线程的死锁

多个线程都占用了对方的资源锁, 但不肯相让, 导致了死锁

```java
public class DeadLock {
    public static void main(String[] args) {
        DeadLockDemo deadLockDemo1 = new DeadLockDemo(true);
        DeadLockDemo deadLockDemo2 = new DeadLockDemo(false);
        deadLockDemo1.start();
        deadLockDemo2.start();
    }
}
class DeadLockDemo extends Thread{
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1){
                System.out.println(Thread.currentThread().getName());
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }else{
            synchronized (o2){
                System.out.println(Thread.currentThread().getName());
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }
    }
}
```

#### 释放锁

下面操作会释放锁

1. 当前线程的同步方法, 同步代码块执行结束
2. 当前线程的同步方法, 同步代码块执行中遇到break, return
3. 当前线程的同步方法, 同步代码块中出现了未处理的Error或Exception, 导致异常结束
4. 当前线程的同步方法, 同步代码块中执行了线程对象的wait()方法, 当前线程暂停, 并释放锁

下面操作不会释放锁

1. 线程执行同步代码块或同步方法时, 程序员调用Thread.sleep(), Thread.yield()方法暂停当前线程的执行, 不会释放锁
2. 线程执行同步代码块或同步方法时,其他线程调用了该线程的suspend()方法将该线程挂起, 该线程不会释放锁

### IO流

#### 文件流

- 流：数据在数据源文件和程序文件之间经历的路径
- 输出流: 从数据源到程序的路径
- 输入流: 从程序到数据源的路径

```java
File file = new File("d:\\text.txt");
try {
    file.createNewFile();
    System.out.println("success");
} catch (IOException e) {
    e.printStackTrace();
}
System.out.println(file.getAbsolutePath());
System.out.println(file.exists());
System.out.println(file.isDirectory());
file.delete();
file.list();
```

#### IO流原理

- 处理数据传输. 如读写文件, 网络通讯
- 对于数据的输入/输出操作以"流strem" 的方式进行
- io包下提供了各种"流"类和接口.

#### 流的分类

- 按操作数据单位不同分为: 字节流(8 bit) 二进制文件(图片,录音), 字符流(按字符)文本文件
- 按流向不同: 输入流, 输出流
- 按流的角色不同分为: 节点流, 处理流/包装流

| 抽象基类 | 字节流       | 字符流 |
| -------- | ------------ | ------ |
| 输入流   | InputStream  | Reader |
| 输出流   | OutputStream | Writer |

1. io流共涉及40多个类, 实际上非常规则, 都是从如上4个抽象类派生的
2. 由这四个类派生出来的子类名称都是以其父类名作为子类后缀

```java
// 节点流
public void readFile02(){
    String filePath = "d:\\text.txt";
    FileInputStream fileInputstream = null;
    int read = 0;
    int readLen = 0;
    byte[]  buf = new byte[8];	// 使用缓冲
    try {
        fileInputstream = new FileInputStream(filePath);
        while((readLen = fileInputstream.read(buf)) != -1){
            System.out.print(new String(buf, 0, readLen));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        try {
            fileInputstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

- 节点流可以从一个特定的数据源读取数据, 如filereader, filerwriter

- 处理流(包装流)是"连接"在已存在的流之上, 为程序提供更为强大的读写功能, 如bufferedreader, bufferedwriter

处理流和节点流的区别和联系

1. 节点流是底层流, 直接跟数据源相连
2. 处理流包装节点流, 既可以消除不同节点流的现实差异, 也可以提供更方便的方法来完成输入输出
3. 处理流对节点流进行包装, 使用了修饰器设计模式, 不会直接与数据源相连

处理流的功能主要体现在以下两方面:

1. 性能的提高: 主要以增加缓冲的方式来提高输入输出的效率
2. 操作的便捷: 处理流可以提供一系列便捷的方法来依次输入输出大批量数据

- 关闭处理流, 只需要关闭外层流即可

##### 处理流-BufferedInputStream和BufferedOutputStream

```java
// 使用bufferedinputstream和bufferedoutputstream
// 比使用指定inputstream有更多功能
String inputPath = "d:\\";
String outputPath = "d:\\";
BufferedInputStream bufferedInputStream = null;
BufferedOutputStream bufferedOutputStream = null;

try {
    bufferedInputStream = new BufferedInputStream(new FileInputStream(inputPath));	
    // 传入任意实现Inputstream抽象类的类
    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputPath));

    byte[] buf = new byte[1024];
    int readLen = 0;
    while ((readLen = bufferedInputStream.read(buf)) != -1){
        bufferedOutputStream.write(buf,0,readLen);
    }

} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        bufferedInputStream.close();
        bufferedOutputStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

#### 序列化和反序列化

- 序列化就是在保存数据时, 保存数据的值和数据类型
- 反序列化就是在恢复数据时, 恢复数据的值和数据的类型
- 需要让某个对象支持序列化机制, 则必须让其类时可序列化的, 该类必须实现如下两个接口之一
  - Serializable		// 推荐, 没有方法, 是个标记接口
  - Externalizable

##### ObjectInputStream 反序列化 / ObjectOutputStream 序列化

```java
public class ObjectStream_ {
    public static void main(String[] args) {
        // 序列化后，保存的文件格式dat
        String filePath = "d:\\...dat";

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeInt(100);
            oos.writeBoolean(true);
            oos.writeChar('a');
            oos.writeDouble(123.23);
            oos.writeUTF("ajsdfo");
            oos.writeObject(new Dog("dog1", 12));
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test	// 反序列化
    public void ObjInputStream_() throws IOException,ClassNotFoundException{
        String filePath = "d:\\...dat";

        // 顺序必须保持一致
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object o = ois.readObject();
        // 如果想要调用反序列化来的类型的方法，需要重新import这个类
        // Dog dog = (Dog) o;   错误
        ois.close();
    }
}

// 如果需要实现序列化，需要实现Serializable接口
class Dog implements Serializable {
    private String name;
    private int age;
    private static String nation = "123";	//不会被序列化
    private transient String color = "432";	//不会被序列化
    private Master master = new Master();	//如果该类没有实现可序列化接口,则报错
    // 序列化的版本号, 可以提高兼容性
    private static final long serialVersionUID = 1L;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}' + 
            	nation + ' ' + color;	// 打印null
    }
}
```

###### 注意

- 序列化读写顺序要一致
- 要求序列化和反序列化对象需要实现Serializable接口
- 序列化的类中建议添加SerialVersionUID, 提高版本兼容性
- 序列化对象时, 除了static transient修饰的成员, 将其他所有属性都进行序列化
- 序列化对象时, 要求里面的属性的类型也需要实现序列化接口

#### 转换流

- InputStreamReader -> 字节流转字符流

- OutputStreamWriter -> 字节流转字符流

- 当处理纯文本数据时, 字符流效率更高, 而且有效解决中文问题
- 可以指定编码格式

```java
public class StreamConvert {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), "utf8");
        osw.write("jasdofi");
        osw.close();
    }

    @Test
    public void InputStreamToReader() throws IOException{
        // 读取gbk编码格式文件
        String filePath = "d:\\";
        // 先读取字节流, 再用InputStreamReader把字节改成字符, 然后再用缓冲流去编辑
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        BufferedReader br = new BufferedReader(isr);
        
        String str = br.readLine();
        System.out.println(str);
        br.close();
        
    }
}
```

#### 打印流

```java
PrintStream ps = System.out;
// 修改打印流输出位置
System.setOut(new PrintStream("d:\\text.txt"));
ps.write("oijoasf".getBytes());
ps.close();
```

#### Properties 类

- 专门用于读取配置文件的集合类
  - 键=值
- 键值对不需要空格, 值不需要引号. 默认类型是String
- 常见方法
  - load: 加载文件到Properties类
  - list: 显示数据
  - getProperty(key):根据键获取值
  - setProperty(key,value): 更新或创建
  - store: 储存到配置文件, 如果是中文用unicode编码

```java
public static void main(String[] args) throws IOException {
    Properties properties = new Properties();
    properties.load(new FileReader("...properties"));
    properties.list(System.out);
    properties.getProperty("123");
    properties.setProperty("123","321");
}
```

### 网络通讯

概念：两台设备之间通过网络实现数据传输

网络通信：将数据通过网络从一台设备传输到另一台设备

java.net包下提供了一系列类和接口

- 局域网: 覆盖范围最小, 覆盖一个教室或机房
- 城域网:覆盖范围较大, 覆盖一个城市
- 广域网:覆盖范围最大, 可以覆盖全国甚至全球, 万维网是广域网的代表

ip地址:

1. 概念: 用于唯一标识网络中的每一台主机
2. 地址的组成 = 网络地址 + 主机地址
   1. ipv4: 四字节(32位), 十进制
   2. ipv6: 十六字节, 十六进制

- ipv4地址分A,B,C,D,E类, 常用为ABC类

#### 域名和端口

##### 域名

- 好处: 为了方便记忆
- 概念: 将ip地址映射成域名

##### 端口号

- 概念: 用于标识计算机上某个特定的网络程序
- 表示形式: 十进制, 两个字节
- 0~1024端口已被占用

#### 网络协议

- TCP/IP 协议
  - 传输控制协议/英特网互联协议
  - 由网络层的ip协议和传输层的tcp协议组成的

![TCP/IP](.\img\TCP_IP.jpg)

![TCP/IP流程](.\img\TCP_IP_process.jpg)

- TCP vs UDP

  - TCP: 传输控制协议
    - 使用协议前, 需要先建立TCP连接, 形成传输数据通道
    - 传输前, 采用"三次握手"方式, 是**可靠的**
    - TCP协议进行通信的两个应用进程: 客户端, 服务端
    - 在连接中可进行大数据量的传输
    - 传输完毕, 需要释放已建立的连接, **效率低**

  ![三次握手](.\img\三次握手.gif)

  - UDP
    - 将数据, 源, 目的封装成数据包, 不需要建立连接
    - 每个数据包的大小限制在64K内, 不适合传输大量数据
    - 因无需连接, 故是**不可靠**的
    - 发送数据结束时无需释放资源(因为不是面向连接的), **速度快**


#### InetAddress 类

```java
InetAddress localHost = InetAddress.getLocalHost();
System.out.println(localHost);

InetAddress host = InetAddress.getByName("LAPTOP-KHRKSM31");
System.out.println(host);

InetAddress web = InetAddress.getByName("www.baidu.com");
System.out.println(web);

String hostAddress = host.getHostAddress();
System.out.println(hostAddress);

String hostName = web.getHostName();
System.out.println(hostName);
```

#### Socket

1. 套接字(Socket)开发网络应用被广泛采用, 以至于成为事实上的标准
2. 通信的两端都要有Socket, 是两台机器间通信的端点
3. 网络通信其实就是Socket间的通信
4. Socket允许程序把网络连接当成一个流, 数据在两个Socket间通过IO传输
5. 一般主动发起通信的应用程序属于客户端, 等待通信请求的为服务端
6. 有两种编程方式: TCP 和 UDP

#### TCP网络通讯编程

- 基于客户端----服务端的网络通信
- 底层使用的是TCP/IP协议
- 基于Socket的TCP编程

```java
// 客户端
// 连接InetAddress.getLocalHost()这台主机的9999端口
Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
// 通过socket获取输出流对象
OutputStream outputStream = socket.getOutputStream();
// 通过输出流 写入数据到数据通道
outputStream.write("hello server".getBytes());
socket.shutdownOutput();

InputStream inputStream = socket.getInputStream();
byte[] buf = new byte[1024];
int readLen = 0;
while((readLen = inputStream.read(buf)) != -1){
    System.out.println(new String(buf,0,readLen));
}
// 关闭流对象和socket 必须关闭
outputStream.close();
inputStream.close();
socket.close();
```

```java
// 服务端
// 9999端口监听 不能有其他程序在同一个Socket监听
ServerSocket serverSocket = new ServerSocket(9999);
// 当没有客户端连接9999端口，程序会堵塞，等待连接
// 如果有客户端连接, 则会返回Socket对象, 程序继续
// ServerSocket可以通过accept返回多个Socket[多并发/多个客户端连接服务器的并发]
Socket accept = serverSocket.accept();

InputStream inputStream = accept.getInputStream();

byte[] buf = new byte[1024];
int readLen = 0;
while((readLen = inputStream.read(buf)) != -1){
    System.out.println(new String(buf,0,readLen));
}

OutputStream outputStream = accept.getOutputStream();
outputStream.write("this is server".getBytes());

accept.shutdownOutput();
// 关闭输入流和socket
inputStream.close();
outputStream.close();
accept.close();
serverSocket.close();
```

关于字符流，使用InputStreamReader和OutputStreamWriter来转换字节流到字符流

还有不同在于使用newLine代替shutdownOutput，以及使用readLine来获取字符流

socket.getOutputStream相关的流要在最后关闭，否则报错

##### netstat

- 指令用来查看端口监听情况和网络连接情况

当客户端连接到服务端后，实际上客户端也是通过一个端口和服务端进行通讯的，这个端口是TCP/IP来分配的，是不确定的

#### UDP 网络通信编程

- 类DatagramSocket和DatagramPacket[数据包/数据报] 实现了基于UDP协议网络程序
- UDP数据报通过数据报套接字DatagramSocket发送和接收, 系统不保证UDP数据报一定能安全送到目的地, 也不能确定什么时候可以抵达
- DatagramPacket对象封装了UDP数据报, 在数据报中包含了发送端的IP地址和端口号以及接收端的IP地址和端口号
- UDP协议中每个数据报都给出了完整的地址信息, 因此无需建立发送方和接收方的连接

```java
// 创建DatagramSocket对象, 准备在9999端口接收
DatagramSocket socket = new DatagramSocket(9999);
// 构建一个DatagramPacket对象, 准备接收
// 数据报最大64k
byte[] buf = new byte[1024];
DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

// 调用接收方法, 将通过网络传输的DatagramPacket对象
// 填充到packet对象
// 当数据报发送到本机9999端口时, 就会接收到数据
// 如果没有数据报发送到, 就会堵塞
socket.receive(datagramPacket);

// 把packet拆包, 取出数据
int length = datagramPacket.getLength();
byte[] data = datagramPacket.getData();

String s = new String(data, 0, length);
System.out.println(s);

data = "hello, too".getBytes();
DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.100"), 6060);
// 发送数据
socket.send(packet);

socket.close();
```

### 项目开发流程 简介

1. 需求分析
   - 需求分析师: 懂技术+行业
     - 出一个需求分析报告, 该项目功能, 客户具体要求
2. 设计阶段
   - 架构师/项目经理
     - 设计工作(UML类图, 流程图, 模块设计, 数据库, 构架)
     - 原型开发
     - 组建团队
3. 实现阶段
   - 程序员
     - 完成架构师的模块功能
     - 测试自己模块
4. 测试阶段
   - 测试工程师
     - 单元测试, 白盒测试, 测试用例, 黑盒测试, 集成测试
5. 实施阶段
   - 实施工程师
     - 将项目正确的部署到客户的平台, 并保证正常运行
6. 维护阶段
   - 发现bug解决/项目升级































### 经典面试题

1. 为什么重写 equals 还要重写 hashcode？
   - 如果重写equals, 那么equals就只是比较两边对象的地址是否相同
2. == 和 equals 比较的区别
   1. ==用来判断两边是不是指向同一个内存地址, equals用来判断两边所指的内存空间的值是否相同
   2. ==是运算符号, equals是一个方法
   3. ==比equals运行速度快, 因为==只是比较引用
3. 为啥有时会出现 4.0 - 3.6 = 0.40000001 这种现象？
   - 由于浮点计算的精度问题引起. 浮点数是二进制, 无法精准表达十进制. 在浮点数计算时,会出现误差.
4. final 关键字的作用
   - 不希望类被继承时, 使用final修饰类
   - 不希望父类某个方法被子类覆盖, 使用final修饰方法
   - 不希望类的某个属性的值被修改, 用final修饰
   - 不希望某个局部变量被修改, 用final修饰
5. 介绍 Java 的集合类
   - List
     - List集合类中元素有序(添加顺序和取出顺序一致)，且可以重复
     - List和集中的每个元素都有对应的顺序索引
   - Set
     - 无序，没有索引
     - 不允许重复元素, 所以最多包含一个null
     - 可以使用迭代器和增强for
6. ArrayList 和 LinkedList 的区别

|            | 底层结构 | 增删效率           | 查找效率 |
| ---------- | -------- | ------------------ | -------- |
| ArrayList  | 可变数组 | 较低, 数组扩容     | 较高     |
| LinkedList | 双向列表 | 较高, 通过链表追加 | 较低     |

