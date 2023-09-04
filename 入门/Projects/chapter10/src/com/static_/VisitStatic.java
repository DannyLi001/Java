package com.static_;

public class VisitStatic {
    public static void main(String[] args) {
//        System.out.println(A.name);
//        A a = new A();
//        System.out.println(a.name);
        Student name1 = new Student("name1");
        Student.pay(100);
        name1.pay(200);
        Student.show();
        System.out.println(Tool.sum(3.2, 5.1));
    }
}
class Tool{
    public static double sum(double n1, double n2) {
        return n1 + n2;
    }
}

class A{
    public static String name = "name1";
}
class Student {
    private String name;
    private static double fee = 0;

    public Student(String name) {
        this.name = name;
    }

    //静态方法
    public static void pay(double fee) {
        Student.fee += fee;
    }
    public static void show(){
        System.out.println(Student.fee);
    }
}