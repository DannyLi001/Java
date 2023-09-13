package com.hspedu.extend.improve;

// 父类，是pupil和graduate的父类
public class Student {
    // 共有属性
    public String name;
    public int age;
    private double score;

//    public Student() {
//    }

    public Student(int age, double score) {
        this.age = age;
        this.score = score;
    }

    public void common(){}
}
