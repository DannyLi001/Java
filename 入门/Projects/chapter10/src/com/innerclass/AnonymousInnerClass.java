package com.innerclass;


public class AnonymousInnerClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.method();
    }
}
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
        /*
            class OuterClass$1 implements A{}
         */
        // 7. jdk底层再创建匿名内部类 OuterClass$1, 立即就创建了实例, 并把地址放回给了tiger
        // 8. 匿名内部类使用一次就不能再使用了
        A tiger = new A() { // 匿名内部类
            @Override
            public void cry() {
                System.out.println("tiger cry");
            }
        };
        tiger.cry();

//        A tiger = new Tiger();
//        tiger.cry();

        // 1. father编译类型 Father
        // 2. father运行类型 匿名内部类 OuterClass$2
        // 3. 底层内部结构
        /*
            class OuterClass$2 extends Father{}
         */
        // 4. 同时也返回了 匿名内部类 OuterClass$2 对象
        // 5. 参数列表会传递给构造器
        Father father = new Father("name1"){
            @Override
            public void test() {
                System.out.println("new test");
            }
        };
        System.out.println(father.getClass());
    }
}

interface A { // 接口
    public void cry();
}
//class Dog implements A{
//    @Override
//    public void cry() {
//        System.out.println("dog cry");
//    }
//}
//class Tiger implements A {
//    @Override
//    public void cry() {
//        System.out.println("tiger cry");
//    }
//}

class Father {
    public Father(String name) {
    }

    public void test(){}
}