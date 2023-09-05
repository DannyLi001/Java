package com.innerclass;

public class StaticInnerClass {
}
class Outer2{
    private int n1 = 10;
    private static String name;

    static class Inner2{
        public void say(){
            System.out.println(name);
        }
    }
}