package com.map_;

import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("123",1);
        properties.put("123",2);
        properties.put("321",1);
        properties.put("213",1);
        System.out.println(properties);
        System.out.println(properties.keySet());
    }
}
