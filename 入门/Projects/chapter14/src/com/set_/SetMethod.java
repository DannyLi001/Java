package com.set_;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class SetMethod {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(4);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(1);
        hashSet.add(null);
        System.out.println(hashSet);
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        iterator = hashSet.iterator();
        for (Object o :hashSet) {
            System.out.println(o);
        }
        HashSet hashSet1 = new HashSet();
        for (int i = 0; i < 100; i++) {
            hashSet1.add("something" + i);
        }
    }
}
