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

![二维数组内存中存在形式](.\2Dlist_JVM_Show.jpg)

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
class Cat {
	String name;
	int age;
	String color;
	double weight;
}
// main
Cat cat1 = new Cat();
cat1.name = "miao";
cat1.age = 3;
...
```

#### 对象的存在形式

创建对象后, 对象的变量名在栈中指向一个地址, 相同地址在堆中储存对象的数据, 如果数据为基础类型数组, 则储存在堆中对象地址下, 如果为引用类型, 则堆中储存一个方法区地址, 该地址在方法区的常量池中. 在常量池相同地址里储存引用类型数据.

![对象在内存中的存在形式](.\Object_JVM_Show.jpg)



















### 经典面试题

1. 为什么重写 equals 还要重写 hashcode？
2. == 和 equals 比较的区别
   1. ==用来判断两边是不是指向同一个内存地址, equals用来判断两边所指的内存空间的值是否相同
   2. ==是运算符号, equals是一个方法
   3. ==比equals运行速度快, 因为==只是比较引用
3. 为啥有时会出现 4.0 - 3.6 = 0.40000001 这种现象？
   - 由于浮点计算的精度问题引起. 浮点数是二进制, 无法精准表达十进制. 在浮点数计算时,会出现误差.
4. final 关键字的作用
5. 介绍 Java 的集合类
6. ArrayList 和 LinkedList 的区别