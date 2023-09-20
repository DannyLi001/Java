package com.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author
 */
public class Reflection3 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class person = Class.forName("com.reflection.Person");
        System.out.println(person.getName());
        System.out.println(person.getSimpleName());
        Field[] fields = person.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        Field[] declaredFields = person.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        Method[] methods = person.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }


    }
}
class A{
    public String hobby;
}
class Person extends A{
    public String name;
    protected int age;
    String job;
}