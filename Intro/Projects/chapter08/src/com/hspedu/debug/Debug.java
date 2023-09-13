package com.hspedu.debug;

public class Debug {
    public static void main(String[] args) {
        Person p1 = new Person("name", 12);
        System.out.println(p1);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}