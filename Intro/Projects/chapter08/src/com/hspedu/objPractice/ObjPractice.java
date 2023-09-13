package com.hspedu.objPractice;

public class ObjPractice {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("person1", 32, "job1");
        people[1] = new Person("person2", 21, "job2");
        people[2] = new Person("person3", 13, "job3");

        Person tmp;
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].age > people[j + 1].age) {
                    tmp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }

    }
}

class Person {
    String name;
    int age;
    String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
