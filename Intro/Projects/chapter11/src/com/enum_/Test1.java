package com.enum_;

/**
 * @author
 */
public class Test1 {
    public static void main(String[] args) {
        new Dog().shout();
        new Cat().shout();
    }
}
abstract class Animal{
    abstract void shout();
}
class Cat extends Animal{
    @Override
    void shout() {
        System.out.println("Miao");
    }
}
class Dog extends Animal{
    @Override
    void shout() {
        System.out.println("Woaf");
    }
}