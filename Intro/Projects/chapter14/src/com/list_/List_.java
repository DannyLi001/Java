package com.list_;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class List_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("123");
        list.add("456");
        list.add(1, "234");
        System.out.println(list);
        List list1 = new ArrayList();
        list1.addAll(list);
        System.out.println(list1);
        list.indexOf("123");
        list.lastIndexOf("234");
        list.remove(1);
        System.out.println(list);
        list.set(0,"789");
        System.out.println(list);

        List list3 = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list3.add(i);
        }
        list3.add(1,"new");
        System.out.println(list3.get(4));
        list3.remove(5);
        list3.set(6,"new1");
        Iterator iterator = list3.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        System.out.println(list3);

    }

}
