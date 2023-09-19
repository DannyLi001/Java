package com.class_;

import com.Cat;

import java.lang.reflect.Field;

/**
 * @author
 */
public class Class1 {
    public static void main(String[] args) {
        String classAllPath = "com.Cat";
        try {
            Class<?> cls = Class.forName(classAllPath);
            System.out.println(cls);
            System.out.println(cls.getClass());
            System.out.println(cls.getPackageName());
            System.out.println(cls.getName());
            Object o = cls.getDeclaredConstructor().newInstance();
            Cat cat = (Cat) o;
            System.out.println(cat);
            Field age = cls.getField("age");
            System.out.println(age.get(cat));
            age.set(cat, 51);
            System.out.println(cat.age);
            Field[] fields = cls.getFields();
            for (Field f1 :fields) {
                System.out.println(f1.getName());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
