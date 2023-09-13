package com.map_;

import java.util.*;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class Map_ {
    public static void main(String[] args) {
        Map employee = new HashMap();
        employee.put("123412", new Employee("name1", 12323));
        employee.put("321321", new Employee("name2", 23321));
        employee.put("123123", new Employee("name3", 13223));
        employee.put("213123", new Employee("name4", 22313));
        System.out.println(employee);
        Set set = employee.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Employee e = (Employee) employee.get(next);
            if (e.getSal() > 18000) {
                System.out.println(e);
            }
        }
        for (Object obj : set) {
            Employee e = (Employee) employee.get(obj);
            if (e.getSal() > 18000) {
                System.out.println(e);
            }
        }

        Collection values = employee.values();
        iterator = values.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Employee e = (Employee) obj;
            if (e.getSal() > 18000) {
                System.out.println(e);
            }
        }

    }
}

class Employee {
    private String name;
    private double sal;

    public Employee(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.sal, sal) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sal);
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
}