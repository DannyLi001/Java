package com.innerclass;

public class LocalInnerClass {
}
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