package com.interface_;

public class ExtendsVSInterface {
    public static void main(String[] args) {
        LittleMonkey wukong = new LittleMonkey("wukong");
        wukong.climbing();
        wukong.swimming();
        wukong.flying();
    }
}
class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing(){
        System.out.println("climb");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
// 继承
class LittleMonkey extends Monkey implements Fishable,Birdable{
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println("monkey swim");
    }

    @Override
    public void flying() {
        System.out.println("monkey fly");
    }
}
interface Fishable {
    void swimming();
}
interface Birdable {
    void flying();
}