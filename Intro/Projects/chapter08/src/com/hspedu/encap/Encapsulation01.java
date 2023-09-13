package com.hspedu.encap;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("nam123123e1");
        p1.setAge(-1);
        p1.setSal(12.1);
        p1.print();
    }

}

class Person {
    public String name;
    private int age;
    private double sal;

    public Person() {
    }

    public Person(String name, int age, double sal) {
        setName(name);
        setAge(age);
        setSal(sal);
    }

    public void setName(String name) {
        if (name.length() > 1 && name.length() < 7) {
            this.name = name;
        } else {
            this.name = "noName";
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 121) {
            this.age = age;
        } else {
            this.age = 50;
        }
    }

    public double getSal() {
        // 对权限进行判断
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public void print() {
        System.out.println(name + " " + age + " " + sal);
    }
}
