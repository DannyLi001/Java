package com.hspedu.objPractice;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
class LabeledPoint extends Point {
    String name;
    public LabeledPoint(String name, double x, double y){
        super(x, y);
        this.name = name;
    }
}

