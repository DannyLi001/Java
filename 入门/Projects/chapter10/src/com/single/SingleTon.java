package com.single;

public class SingleTon {
    public static void main(String[] args) {
        GirlFriend girlFriend = GirlFriend.getInstance();
        System.out.println(girlFriend.toString());
    }
}
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

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}