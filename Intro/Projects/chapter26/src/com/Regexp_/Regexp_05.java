package com.Regexp_;

/**
 * @author
 */
public class Regexp_05 {
    public static void main(String[] args) {
        String content = "-123.32";
        String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        if(content.matches(regStr)){
            System.out.println("success");
        }
    }
}
