package com.hspedu.object;

public class Finalize {
    public static void main(String[] args) {
        Car car1 = new Car("BMW");
        car1 = null; // Car对象现在就是垃圾，垃圾回收器就会回收对象，
        // 在销毁对象前，会调用该对象的finalize方法
        // 我们可以在finalize中, 写自己的代码(eg.释放资源: 数据库链接..)
        // 如果不重写, 会调用Object里的finalize
        System.gc();
    }
}

class Car {
    String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
        super.finalize();
    }
}