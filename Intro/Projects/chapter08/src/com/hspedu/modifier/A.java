package com.hspedu.modifier;

public class A {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public void m1() {
        // 在同类下, 所有都可以访问
        System.out.println(n1 + n2 + n3 + n4);
    }
    protected void m2(){}
    void m3(){}
    private void m4(){}
}
