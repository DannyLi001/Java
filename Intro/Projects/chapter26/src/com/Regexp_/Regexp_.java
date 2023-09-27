package com.Regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author
 */
public class Regexp_ {
    public static void main(String[] args) {
        String content = "";
        // 先创建一个Pattern对象，模式对象，可以理解成一个正则表达式
        Pattern pattern = Pattern.compile("[a-zA-z]+");
        // 创建一个匹配对象
        // 按照pattern(模式), 到content文本中匹配
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
