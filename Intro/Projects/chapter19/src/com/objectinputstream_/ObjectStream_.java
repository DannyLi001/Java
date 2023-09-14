package com.objectinputstream_;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author
 */
public class ObjectStream_ {
    public static void main(String[] args) {
        // 序列化后，保存的文件格式dat
        String filePath = "d:\\...dat";

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeInt(100);
            oos.writeBoolean(true);
            oos.writeChar('a');
            oos.writeDouble(123.23);
            oos.writeUTF("ajsdfo");
            oos.writeObject(new Dog("dog1", 12));
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void ObjInputStream_() throws IOException,ClassNotFoundException{
        String filePath = "d:\\...dat";

        // 顺序必须保持一致
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object o = ois.readObject();
        // 如果想要调用反序列化来的类型的方法，需要重新import这个类
        // Dog dog = (Dog) o;   错误

        ois.close();

    }
}

// 如果需要实现序列化，需要实现Serializable接口
class Dog implements Serializable {
    private String name;
    private int age;
    // 序列化的版本号, 可以提高兼容性
    private static final long serialVersionUID = 1L;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
