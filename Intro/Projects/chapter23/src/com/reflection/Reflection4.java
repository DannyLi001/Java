package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author
 */
public class Reflection4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> carClass = Class.forName("com.reflection.Car");
        Object car1 = carClass.getConstructor().newInstance();
        System.out.println(car1);

        Object car2 = carClass.getConstructor(String.class).newInstance("new");
        System.out.println(car2);

        Constructor<?> declaredConstructor = carClass.getDeclaredConstructor(String.class, double.class);
        declaredConstructor.setAccessible(true);    // 爆破
        Object car3 = declaredConstructor.newInstance("new2", 500000);
        System.out.println(car3);
    }
}
class Car {
    private String brand = "BMW";
    private double price = 1000000;

    public Car() {
    }

    public Car(String brand) {
        this.brand = brand;
    }

    private Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}