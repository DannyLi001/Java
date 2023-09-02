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
  - 运行类型可以改变
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
5. 介绍 Java 的集合类
6. ArrayList 和 LinkedList 的区别