package com.static_;

public class ChildGame {
    public static void main(String[] args) {


        Child child1 = new Child("child1");
        child1.count++;
        Child child2 = new Child("child2");
        child2.count++;
        Child child3 = new Child("child3");
        child3.count++;
        System.out.println(Child.count);
    }
}

class Child {
    private String name;
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }
    public void join(){
        System.out.println(name + "join");
    }
}