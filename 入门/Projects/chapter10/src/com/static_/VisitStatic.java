package com.static_;

public class VisitStatic {
    public static void main(String[] args) {
        System.out.println(A.name);
        A a = new A();
        System.out.println(a.name);
    }
}
class A{
    public static String name = "name1";
}
