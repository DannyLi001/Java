package com;

import java.util.Scanner;

/**
 * @author
 */
public class HW2 {
    public static void main(String[] args) {
        String username;
        String pwd;
        String email;

        Scanner scanner = new Scanner(System.in);
        username = scanner.next();
        if(!(username.length() < 5 && username.length() > 1)){
            throw new RuntimeException("username invalid");
        }
        pwd = scanner.next();

        if(!(pwd.length() == 6 && isDigit(pwd))){
            throw new RuntimeException("pwd invalid");
        }
        email = scanner.next();
        if(!(email.contains("@") && email.contains(".") && email.indexOf('@') < email.indexOf('.'))){
            throw new RuntimeException("email invalid");
        }
        System.out.println("success");
    }
    public static boolean isDigit(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(!(chars[i] >= '0' && chars[i] <= '9')){
                return false;
            }
        }
        return true;
    }
}
