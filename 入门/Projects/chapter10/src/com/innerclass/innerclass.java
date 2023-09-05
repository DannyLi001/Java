package com.innerclass;

public class innerclass {
}
class Outer {
    private int n1;

    public Outer(int n1) {
        this.n1 = n1;
    }

    public void m1(){}

    {
        System.out.println("代码块");
    }
    class Inner {

    }
}