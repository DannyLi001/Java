package com.codeblock;

public class CodeBlock {
    public static void main(String[] args) {
        new Movie();
    }
}
class Movie {
    private String name;
    private double price;
    private String director;
    // 下面的所有构造器有相同的语句
    // 这样代码会冗余
    // 我们把相同的语句放到代码块中
    // 不管调用哪个构造器创建对象, 都会先执行代码块的内容
    // 代码块的优先级高于构造器
    {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
    }

    public Movie() {
    }

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }
}