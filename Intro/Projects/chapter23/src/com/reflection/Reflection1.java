package com.reflection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author
 */
public class Reflection1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 先从properties中读取信息
        Properties properties = new Properties();
        properties.load(new FileReader("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        // 使用反射机制解决
        // 1. 加载类, 返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        // 生成一个Cat对象
        Object o = cls.newInstance();
        System.out.println(o.getClass());
        // 通过cls得到加载的类的methodName方法
        Method method = cls.getMethod(methodName);
        // 通过method对象调用Cat类中的hi方法
        // 方法.invoke(对象)
        method.invoke(o);

        // getField不能得到私有属性
        Field age = cls.getField("age");
        // 成员变量对象.get(对象)
        System.out.println(age.get(o));

        // 无参构造器
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);
        // 带参构造器
        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);
    }
}
