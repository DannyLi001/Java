package com.Properties_;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("charset","utf8");
        properties.setProperty("user","tom");
        properties.setProperty("pwd","123");

        properties.store(new FileOutputStream("...properties"),null);
    }
}
