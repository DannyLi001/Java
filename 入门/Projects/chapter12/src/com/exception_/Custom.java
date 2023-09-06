package com.exception_;

/**
 * @author
 */
public class Custom {
    public static void main(String[] args) {
        int age = 900;
        if(!(age >= 18 && age <= 120)){
            throw new AgeException("something");
        }
    }
}
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}