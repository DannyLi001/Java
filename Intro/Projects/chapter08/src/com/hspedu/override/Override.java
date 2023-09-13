package com.hspedu.override;

public class Override {
    public static void main(String[] args) {
        Person person = new Person();
        Student student = new Student();

        System.out.println(person.say());
        System.out.println(student.say());
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String say() {
        return name + " " + age + "";
    }
}
class Student extends Person {
    private int id;
    private double score;

    public Student() {
    }

    public Student(int id, double score) {
        this.id = id;
        this.score = score;
    }

    public Student(String name, int age, int id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    public String say(){
        return super.say() + " " + id + " " + score;
    }
}