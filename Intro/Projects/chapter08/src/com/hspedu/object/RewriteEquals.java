package com.hspedu.object;

public class RewriteEquals {
    public static void main(String[] args) {
        Person person1 = new Person("person1", 10, 'm');
        Person person2 = new Person("person2", 10, 'm');
        System.out.println(person1.equals(person2));
    }
}
class Person {
    String name;
    int age;
    char sex;

    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    // rewrite equals
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Person){
            Person person = (Person) obj;
            return name.equals(person.name) && age == person.age && sex == person.sex;
        }
        return false;
    }
}
