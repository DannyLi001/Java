package com;

/**
 * @author
 */
public class HW3 {
    public static void main(String[] args) {
        String name = "li jia jun";

        try {
            printName(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void printName(String str){
        if(str == null){
            throw new RuntimeException(" ");
        }
        String[] names = str.split(" ");
        if(names.length != 3){
            throw new RuntimeException(" ");
        }
        String part1 = upperCase(names[names.length - 1]);
        String part2 = upperCase(names[0]);
        char part3 = names[1].toUpperCase().charAt(0);
        System.out.println(part1 + "," + part2 + "."+ part3);
    }
    public static String upperCase(String str){
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return new String(chars);
    }
}
