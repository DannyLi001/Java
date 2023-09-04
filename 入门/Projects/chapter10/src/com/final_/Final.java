package com.final_;

public class Final {
    public static void main(String[] args) {

    }
}
class Circle {
    private double radius;
    private final double PI = 3.14;

    public Circle(double radius) {
        this.radius = radius;
//        PI = 3.14;
    }

//    {
//        PI = 3.14;
//    }

    public final double getArea(){
        return PI * radius * radius;
    }
}