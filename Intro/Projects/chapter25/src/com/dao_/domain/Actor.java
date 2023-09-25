package com.dao_.domain;

/**
 * @author
 */
public class Actor {

    private Integer num;
    private String name;

    public Actor() {
    }

    public Actor(Integer num, String name) {
        this.num = num;
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nActor{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

}
