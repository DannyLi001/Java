package com.hspedu.poly;

public class PolyParam {
    public static void main(String[] args) {
        Worker worker1 = new Worker("worker1", 12);
        Manager manager1 = new Manager("manager1", 31, 21);
        PolyParam polyParam = new PolyParam();
//        polyParam.showEmpAnnual(worker1);
//        polyParam.showEmpAnnual(manager1);
        polyParam.testWork(worker1);
        polyParam.testWork(manager1);
        worker1.equals(manager1);
    }
    public void showEmpAnnual(Employee employee){
        System.out.println(employee.getAnnual());
    }
    public void testWork(Employee employee){
        if(employee instanceof Worker) {
            ((Worker)employee).work();
        } else {
            ((Manager)employee).manage();
        }
    }
}
class Employee {
    String name;
    double sal;

    public Employee(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
    public double getAnnual(){
        return this.sal * 12;
    }

}
class Worker extends Employee{
    public Worker(String name, double sal) {
        super(name, sal);
    }
    public void work() {
        System.out.println("work");
    }
    public double getAnnual(){
        return super.getAnnual();
    }
}
class Manager extends Employee{
    double bonus;

    public Manager(String name, double sal, double bonus) {
        super(name, sal);
        this.bonus = bonus;
    }
    public void manage(){
        System.out.println("manage");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}
