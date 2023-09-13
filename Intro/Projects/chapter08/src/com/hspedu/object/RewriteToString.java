package com.hspedu.object;

public class RewriteToString {
    public static void main(String[] args) {
        Monster monster1 = new Monster("monster", "walk", 12);
        System.out.println(monster1.toString());
        System.out.println(monster1.hashCode());
        System.out.println(monster1);
    }
}

class Monster {
    String name;
    String job;
    double sal;

    public Monster(String name, String job, double sal) {
        this.name = name;
        this.job = job;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }

}
