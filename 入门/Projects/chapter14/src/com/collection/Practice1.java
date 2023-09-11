package com.collection;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author
 */
public class Practice1 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        hashSet.add(p1);
        hashSet.add(p2);
        p1.setName("CC");
        System.out.println(hashSet.remove(p1));
        System.out.println(hashSet);
        hashSet.add(new Person(1001,"CC"));
        System.out.println(hashSet);
        hashSet.add(new Person(1001,"AA"));
        System.out.println(hashSet);
    }
}
class Person{
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Person( int id,String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}