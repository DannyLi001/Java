package com.hspedu.objPractice;

public class
Company {
    public static void main(String[] args) {
        Worker worker1 = new Worker("worker1", 500, 25, 1.0);
        worker1.print();
        Manager manager1 = new Manager("manager1", 1000, 28, 1.2);
        manager1.print();
    }
}

class Employee {
    String name;
    double sal;
    int day;

    public Employee() {
    }

    public Employee(String name, double sal, int day) {
        this.name = name;
        this.sal = sal;
        this.day = day;
    }

    public void print() {
        System.out.println(this);
    }
}

class Manager extends Employee {
    double grade;

    public Manager(String name, double sal, int day, double grade) {
        super(name, sal, day);
        this.grade = grade;
    }

    public void print() {
        System.out.println(1000 + sal * day * grade);
    }
}

class Worker extends Employee {
    double grade;

    public Worker(String name, double sal, int day, double grade) {
        super(name, sal, day);
        this.grade = grade;
    }

    public void print() {
        System.out.println(1000 + sal * day * grade);
    }
}
