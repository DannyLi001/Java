package com.enum_;

/**
 * @author
 */
public class Test4 {
    public static void main(String[] args) {
        Color color = Color.RED;
        color.print();

    }
}

enum Color implements I {
    RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    BLACK(0, 0, 0), YELLOW(255, 255, 0);
    private int redVal;
    private int greenVal;
    private int blueVal;

    Color(int redVal, int greenVal, int blueVal) {
        this.redVal = redVal;
        this.greenVal = greenVal;
        this.blueVal = blueVal;
    }

    @Override
    public void print() {
        System.out.println(this.blueVal + " " + this.greenVal + " " + this.redVal);
    }
}

interface I {
    public void print();
}