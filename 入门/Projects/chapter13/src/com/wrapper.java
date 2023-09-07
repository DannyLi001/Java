package com;

/**
 * @author
 */
public class wrapper {
    public static void main(String[] args) {
        // 手动装箱
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);
        // 手动拆箱
        int i = integer.intValue();

        // 自动装箱和自动拆箱
        int n2 = 200;
        // 自动装箱 int -> Integer
        Integer integer2 = n2; // 底层使用Integer.valueOf(n2);
        // 自动拆箱
        int n3 = integer2; // 底层integer.intValue();



        Integer i2 = 100;
        String str1 = i + "";
        String str2 = i2.toString();
        String str3 = String.valueOf(n2);

        String str4 = "1234";
        Integer i3 = Integer.parseInt(str4);
        Integer i4 = new Integer(str4);

    }
}
