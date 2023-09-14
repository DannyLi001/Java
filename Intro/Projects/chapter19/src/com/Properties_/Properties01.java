package com.Properties_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("...properties"));
        properties.list(System.out);
        properties.getProperty("123");
        properties.setProperty("123","321");
    }
}
