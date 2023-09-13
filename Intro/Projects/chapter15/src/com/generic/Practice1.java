package com.generic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Danny
 */
public class Practice1 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("name1", 10.1, new MyDate(1, 1, 2001)));
        employees.add(new Employee("name2", 10.2, new MyDate(2, 2, 2002)));
        employees.add(new Employee("name3", 10.3, new MyDate(3, 3, 2003)));
        employees.add(new Employee("name3", 10.3, new MyDate(3, 3, 2004)));
        employees.add(new Employee("name3", 10.3, new MyDate(3, 3, 2001)));
        employees.add(new Employee("name3", 10.3, new MyDate(3, 2, 2003)));
        employees.add(new Employee("name3", 10.3, new MyDate(3, 6, 2003)));
        employees.add(new Employee("name3", 10.3, new MyDate(1, 3, 2003)));
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getName().compareTo(o2.getName()) == 0) {
                    return o1.getBirthday().compareTo(o2.getBirthday());
                }
                return (o1.getName().compareTo(o2.getName()));
            }
        });
        System.out.println(employees);
    }
}


class Employee {
    private String name;
    private double sal;
    private MyDate birthday;


    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }
}

class MyDate implements Comparable<MyDate> {
    private int month;
    private int day;
    private int year;

    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    @Override
    public int compareTo(MyDate date) {
        int yearDif = date.getYear() - this.getYear();
        if (yearDif != 0) {
            return yearDif;
        }
        int monDif = date.getMonth() - this.getMonth();
        if (monDif != 0) {
            return monDif;
        }
        int dayDif = date.getDay() - this.getDay();
        if (dayDif != 0) {
            return dayDif;
        }
        return 0;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}