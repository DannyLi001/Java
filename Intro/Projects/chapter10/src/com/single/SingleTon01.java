package com.single;

public class SingleTon01 {
    public static void main(String[] args) {
        Cat cat1 = Cat.getInstance();
        System.out.println(cat1.toString());
    }
}
class Cat {
    private String name;
    private static Cat cat;
    // 1. 构造器私有化
    // 2. 定义一个static静态属性对象
    // 3. 提供一个public的static方法, 可以返回一个Cat对象
    // 4. 懒汉式 只有当用户使用getInstance时, 才会返回对象, 后面再次调用, 返回上次创建的Cat对象
    //    从而保证了单例
    private Cat(String name) {
        this.name = name;
    }
    public static Cat getInstance(){
        if(cat == null) {
            cat = new Cat("cat1");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
