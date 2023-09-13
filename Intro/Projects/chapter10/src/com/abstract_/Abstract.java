package com.abstract_;

public class Abstract {
}

abstract class Animal{
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();
}