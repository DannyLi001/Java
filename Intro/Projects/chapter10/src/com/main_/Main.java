package com.main_;

public class Main {
    private static String name = "name1";
    private String error = "error";

    public static void hi(){
        System.out.println("hi");
    }
    public static void main(String[] args) {
        System.out.println(name);
        Main main = new Main();
        System.out.println(main.error);
        hi();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);

        }
    }
}
