package com.collection;

import java.util.*;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class Practice {
    public static void main(String[] args) {
        News news1 = new News("jasdoifnaovnpowwkmfownefinwoenevopnas");
        News news2 = new News("519871787891621616169841651651551984");
        ArrayList arrayList = new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);
        for (int i = arrayList.size() - 1; i > -1; i--) {
            News n1 = (News) arrayList.get(i);
            String s1 = process(n1.getTitle());
            n1.setTitle(s1);
        }


        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }


        HashMap hashMap = new HashMap();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);
        hashMap.put("smith", 0);
        hashMap.replace("jack", 2600);
        Set set = hashMap.keySet();
        iterator = set.iterator();
        System.out.println(hashMap);
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
            System.out.println(hashMap.get(next));
        }


    }
    public static String process(String str){
        if(str.length() > 15){
            String s1 = str.substring(0, 15);
            return s1 + "...";
        }
        return str;
    }
}

class News {
    private String title;
    private String context;

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}