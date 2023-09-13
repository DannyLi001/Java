package com.generic;

import java.util.*;

/**
 * @author
 */
public class Generic01 {
    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<String, Student>();
        map.put("student1", new Student("student1", 11));
        map.put("student2", new Student("student2", 12));
        map.put("student3", new Student("student3", 13));

        Set<String> set = map.keySet();
        for (Object next : set) {
            System.out.println(map.get(next));
        }

        Set<Map.Entry<String, Student>> entries = map.entrySet();
        Iterator<Map.Entry<String,Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next =  iterator.next();

        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();    // 类
        List<Integer> list = new ArrayList<Integer>();      // 接口

        ArrayList<Integer> arrayList1 = new ArrayList</*省略且推荐*/>();
        List<Integer> list1 = new ArrayList<>();
    }
}
class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}