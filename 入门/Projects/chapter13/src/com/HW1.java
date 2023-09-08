package com;

/**
 * @author
 */
public class HW1 {
    public static void main(String[] args) {
        String str = "12345";

        try {
            str = reverse(str, 1, 3);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println(str);
    }

    public static String reverse(String str, int start, int end) {

        if(!(str != null && end < str.length() - 1 && start > -1)){
            throw new RuntimeException("1");
        }
        char[] chars = str.toCharArray();
        int L = start;
        int R = end;
        char tmp;


        if (start < end) {
            tmp = chars[L];
            chars[L++] = chars[R];
            chars[R++] = tmp;
        }
        return new String(chars);
    }
}
