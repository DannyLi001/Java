package com;

/**
 * @author
 */
public class Cat {
    private String name = "cat1";
    public int age = 12;
    public String type = "type";
    public String owner = "owner";

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi(){
        System.out.println("hi " + name);
    }
}
