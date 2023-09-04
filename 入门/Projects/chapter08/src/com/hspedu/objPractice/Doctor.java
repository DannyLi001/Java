package com.hspedu.objPractice;

public class Doctor {
    private String name;
    private int age;
    private String job;
    private char sex;
    private double sal;

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Doctor)){
            return false;
        }
        Doctor doctor = (Doctor)obj;
        return doctor.age == age && doctor.name.equals(name) &&
                doctor.job.equals(job) && doctor.sex == sex && doctor.sal == sal;
    }

    public static void main(String[] args) {
        Doctor doctor = new Doctor("name1", 12, "job1", 'm', 12);
        Doctor doctor1 = new Doctor("name1", 12, "job1", 'm', 12);
        System.out.println(doctor.equals(doctor1));
    }

    public Doctor(String name, int age, String job, char sex, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.sex = sex;
        this.sal = sal;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}
