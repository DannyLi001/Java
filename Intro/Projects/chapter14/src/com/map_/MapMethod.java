package com.map_;

import java.util.*;

/**
 * @author
 */@SuppressWarnings({"all"})
public class MapMethod {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("1",1);
        hashMap.put("2",2);
        hashMap.put("3",3);
        hashMap.put("4",4);
        hashMap.remove("1");
        System.out.println(hashMap);
        System.out.println(hashMap.size());
        hashMap.clear();
        System.out.println(hashMap.containsKey("1"));
        hashMap.put("1",1);
        hashMap.put("2",2);
        hashMap.put("3",3);
        hashMap.put("4",4);
        hashMap.put("5",4);

        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next+ "=" + hashMap.get(next));
        }
        for (Object o :set) {
            System.out.println(o + "=" + hashMap.get(o));
        }

        Collection values = hashMap.values();
        iterator = values.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }



        Set set1 = hashMap.entrySet();
        for (Object o :set1) {
            Map.Entry m = (Map.Entry) o;
            System.out.println(m.getKey());
        }

    }
}
