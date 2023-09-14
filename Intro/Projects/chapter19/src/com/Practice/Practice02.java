package com.Practice;

import java.io.*;
import java.util.Properties;

/**
 * @author
 */
public class Practice02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String filePath = "d:\\...properties";
        Properties properties = new Properties();
        properties.put("name","tom");
        properties.put("age",5);
        properties.put("color","red");
        properties.store(new FileWriter(filePath), null);

        properties.load(new FileReader(filePath));

        Dog dog = new Dog(properties.get("name") + "", Integer.parseInt(properties.get("age") + ""), properties.get("color") + "");

        filePath = "d:\\...dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(dog);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        Object o = ois.readObject();
        Dog dog1 = (Dog) o;
    }
}

class Dog implements Serializable{
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}