package com.exception_;

/**
 * @author
 */
public class Exception01 {
    public static void main(String[] args) {
        try {
            System.out.println(10/0);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
