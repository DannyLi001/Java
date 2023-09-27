package com.Regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author
 */
public class Regexp_02 {
    public static void main(String[] args) {
        String content = "abc$(123(abc(";
        String regStr = "\\(";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
