package com.hspedu.poly;

public class PolyArray {
    public static void main(String[] args) {
        Person[] people = new Person[5];
        people[0] = new Student("student1", 12, 89);
        people[1] = new Teacher("teacher1", 40, 42389);
        people[2] = new Teacher("teacher2", 32, 1234);
        people[3] = new Teacher("teacher3", 13, 1234123);
        people[4] = new Teacher("teacher4", 43, 1234179);
        for (int i = 0; i < people.length; i++) {
            System.out.println((people[i].say()));
            if(people[i] instanceof Student){
                ((Student)people[i]).study();
            } else if (people[i] instanceof Teacher){
                ((Teacher)people[i]).teach();
            } else {
                System.out.println("wrong");
            }
        }
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String say() {
        return name + "\t" + age;
    }
}

class Student extends Person {
    double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + "\t" + score;
    }
    public void study(){
        System.out.println("study");
    }
}

class Teacher extends Person {
    double sal;

    public Teacher(String name, int age, double sal) {
        super(name, age);
        this.sal = sal;
    }

    @Override
    public String say() {
        return super.say() + "\t" + sal;
    }
    public void teach(){
        System.out.println("teach");
    }
}