package com.Regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author
 */
public class Regexp_03 {
    public static void main(String[] args) {
        String content = "asd 1551 2335";
        String regStr = "(\\d)(\\d)\\2\\1";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

    }

}
