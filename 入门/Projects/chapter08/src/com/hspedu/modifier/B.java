package com.hspedu.modifier;

public class B {
    public void say() {
        A a = new A();
        // 在同包下, 只有private不能访问
        System.out.println(a.n1 + a.n2 + a.n3);
    }
}
