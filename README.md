# Java

## 入门

### Java特点

- Java语言是面向对象的(oop)
- Java语言是健壮的: 强类型机制, 异常处理, 垃圾的自动收集等
- Java语言是跨平台性的 (编译好的.class文件可以在多个系统下运行)
- Java语言是解释型的
  - 解释性语言: javascript, PHP, java	编译性语言:c/c++
  - 区别是: 解释性语言,编译后的代码,不能被机器直接执行,需要解释器. 编译性语言,编译后代码可以直接被执行

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





















### 经典面试题

1. 为什么重写 equals 还要重写 hashcode？
2. == 和 equals 比较的区别
3. 为啥有时会出现 4.0 - 3.6 = 0.40000001 这种现象？
4. final 关键字的作用
5. 介绍 Java 的集合类
6. ArrayList 和 LinkedList 的区别