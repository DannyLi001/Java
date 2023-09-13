package com.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class Collection_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("string");
        list.add(true);
        list.add(1);
        list.remove(0);
        list.remove(true);
        list.contains(true);
        System.out.println(list.size());
        list.isEmpty();
        list.clear();
        ArrayList arrayList = new ArrayList();
        arrayList.add("147");
        arrayList.add("456");
        list.addAll(arrayList);
        System.out.println(list);
        list.contains(arrayList);
        list.add("789");
        System.out.println(list);
        list.removeAll(arrayList);
        System.out.println(list);
    }
}
