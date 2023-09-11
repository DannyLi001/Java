package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class CollectionTools {
    public static void main(String[] args) {

        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("werwer");
            arrayList.add("sdf");
            arrayList.add("bdfb");
            arrayList.add("zdc");
            arrayList.add("cwe");
            System.out.println(arrayList);
            Collections.reverse(arrayList);
            System.out.println(arrayList);
            Collections.shuffle(arrayList);
            System.out.println(arrayList);
            Collections.sort(arrayList);
            System.out.println(arrayList);
            Collections.sort(arrayList, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    return ((String) o1).length() - ((String) o2).length();
                }
            });
            System.out.println(arrayList);
            Collections.swap(arrayList, 0, 1);
            System.out.println(arrayList);
            System.out.println(Collections.max(arrayList));

            Object obj = Collections.max(arrayList, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    return ((String) o1).length() - ((String) o2).length();
                }
            });
            System.out.println(obj);
            System.out.println(Collections.frequency(arrayList, "123"));
            ArrayList arrayList1 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList1.add("");
            }
            Collections.copy(arrayList1,arrayList);
            System.out.println(arrayList1);
            Collections.replaceAll(arrayList1, "sdf", "123");
            System.out.println(arrayList1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
