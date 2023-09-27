package com.Regexp_;

/**
 * @author
 */
public class Regexp_06 {
    public static void main(String[] args) {
        String content = "";
        String regStr = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.]+)$";
        if(content.matches(regStr)){
            System.out.println("success");
        }
    }
}
