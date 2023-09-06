package com.exception_;

import java.lang.reflect.Array;

/**
 * @author
 */
public class EcmDef {
    public static void main(String[] args) {

        try {
            if(args.length != 2){
                throw new ArrayIndexOutOfBoundsException("something0");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            double result = cal(n1, n2);
            System.out.println(result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("something1");
        } catch (ArithmeticException e){
            System.out.println("something2");
        }
    }

    public static double cal(int n1, int n2) {
        return (double)n1 / n2;
    }
}
