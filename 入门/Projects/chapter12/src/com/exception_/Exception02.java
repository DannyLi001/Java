package com.exception_;

import java.util.Scanner;

/**
 * @author
 */
public class Exception02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        int i = 0;
        while (true){
            str = scanner.next();
            try{
                i = Integer.parseInt(str);
                break;
            } catch (Exception e){
                System.out.println();
            }
        }
    }
}
