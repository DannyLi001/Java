package com.hspedu.poly;

public class PolyObject {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.cry(); // 到这里 animal的运行类型是Dog cry是dog cry
        animal = new Cat();
        animal.cry(); // 到这里 animal的运行类型是Dog cry是dog cry
    }
}

class Animal {
    public void cry(){
        System.out.println("animal");
    }
}

class Cat extends Animal {
    public void cry(){
        System.out.println("cat");
    }
}

class Dog extends Animal {
    public void cry(){
        System.out.println("dog");
    }
}

