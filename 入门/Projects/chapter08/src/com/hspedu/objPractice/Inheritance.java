package com.hspedu.objPractice;

public class Inheritance {
    public static void main(String[] args) {

    }
}
class Teacher {
    String name;
    int age;
    String post;
    double sal;
    double grade;

    public Teacher(String name, int age, String post, double sal, double grade) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.sal = sal;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", sal=" + sal +
                '}';
    }
    public void introduce(){
        System.out.println(this.toString());
    }

}

class Professor extends Teacher{
    public Professor(String name, int age, String post, double sal, double grade) {
        super(name, age, post, sal, grade);
    }

    public void introduce(){
        super.introduce();
    }

}
