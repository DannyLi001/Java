package com.abstract_;

public class Exercise {
    public static void main(String[] args) {
        Manager name1 = new Manager("name1", "1029301", 12334, 2000);
        name1.work();
    }
}

abstract class Employee {
    private String name;
    private String id;
    private double sal;

    public Employee(String name, String id, double sal) {
        this.name = name;
        this.id = id;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public abstract void work();
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, String id, double sal, double bonus) {
        super(name, id, sal);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println(getName() + " working...");
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

class CommonEmployee extends Employee {
    public CommonEmployee(String name, String id, double sal) {
        super(name, id, sal);
    }

    @Override
    public void work() {
        System.out.println(getName() + " working...");
    }
}