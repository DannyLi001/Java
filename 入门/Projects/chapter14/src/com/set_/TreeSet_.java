package com.set_;

import com.sun.source.util.Trees;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class TreeSet_ {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo((String) o2);
            }
        });
        treeSet.add("z");
        treeSet.add("d");
        treeSet.add("g");
        treeSet.add("s");
        treeSet.add("null");
        System.out.println(treeSet);

        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        treeMap.put("123","asda");
        treeMap.put("sd","wefa");
        treeMap.put("fwe","ddfsa");
        treeMap.put("fes","effa");
        System.out.println(treeMap);
    }
}
