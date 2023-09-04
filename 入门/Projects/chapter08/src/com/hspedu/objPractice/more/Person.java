package com.hspedu.objPractice.more;

import javax.xml.stream.events.StartDocument;

public class Person {
    private String name;
    private char sex;
    private int age;

    public static void main(String[] args) {
        Student student1 = new Student("student1", 'm', 12, "123124");
        Teacher teacher1 = new Teacher("teacher1", 'f', 32, 21);
//        student1.printInfo();
//        teacher1.printInfo();
        Person[] people = new Person[4];
        people[0] = student1;
        people[1] = teacher1;
        people[2] = new Student("student2", 'f', 21, "000213");
        people[3] = new Teacher("teacher2", 'm', 41, 23);
        Person person = new Person();
        person = student1;
        System.out.println(person.play());

        person.sort(people);
        for (int i = 0; i < people.length; i++) {
//            System.out.println(people[i]);
//            person.test(people[i]);
        }

    }

    public Person() {
    }

    public void test(Person person) {
        if(person instanceof Teacher){
            ((Teacher)person).teach();
        } else if (person instanceof Student){
            ((Student)person).study();
        }
    }


    public void sort(Person[] people){
        if(people.length > 1){
            Person tmp;
            for (int i = 0; i < people.length - 1; i++) {
                for (int j = 0; j < people.length - 1 - i; j++) {
                    if(people[j].age < people[j + 1].age){
                        tmp = people[j];
                        people[j] = people[j + 1];
                        people[j + 1] = tmp;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String play(){
        return name + " play ";
    }
    public void printInfo(){
        System.out.print("'s Info:" + "\nname: " + name + "\nage: " + age + "\nsex: " + sex);
    }
}
class Student extends Person{
    private String stu_id;

    public Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }
    public void study(){
        System.out.println("study");
    }
    public String play(){
        return super.play() + "soccer";
    }

    public void printInfo(){
        System.out.print("Student");
        super.printInfo();
        System.out.println("\nid: " + stu_id);
        study();
        System.out.println(play());
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "stu_id='" + stu_id + '\'' +
                '}';
    }
}
class Teacher extends Person{
    private int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }
    public void teach(){
        System.out.println("teach");
    }
    public String play(){
        return super.play() + "chess";
    }

    public void printInfo(){
        System.out.print("Teacher");
        super.printInfo();
        System.out.println("\nwork age: " + work_age);
        teach();
        System.out.println(play());
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                super.toString() +
                "work_age=" + work_age +
                '}';
    }
}
