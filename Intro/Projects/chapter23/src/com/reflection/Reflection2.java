package com.reflection;

import com.Cat;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author
 */
public class Reflection2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();
        switch (key){
            case "1":
//                Cat cat = new Cat;  // 静态加载
                break;
            case "2":
                Class<?> cls = Class.forName("com.Cat");    //动态加载
                Object o = cls.getConstructor().newInstance();
                Method m = cls.getMethod("hi");
                m.invoke(o);
                break;
        }
    }

}
