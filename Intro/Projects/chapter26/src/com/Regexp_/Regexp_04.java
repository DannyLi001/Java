package com.Regexp_;

/**
 * @author
 */
public class Regexp_04 {
    public static void main(String[] args) {
        String content = "550744054@qq.com";
        String regStr = "[\\w]+@([a-zA-z]+\\.)+[a-zA-Z]+";
        if(content.matches(regStr)){
            System.out.println("success");
        }
    }
}
