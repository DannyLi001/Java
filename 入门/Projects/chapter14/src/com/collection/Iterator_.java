package com.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class Iterator_ {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        arrayList.add(new Book("book1","author1",1.1));
        arrayList.add(new Book("book2","author2",2.1));
        arrayList.add(new Book("book3","author3",3.1));

        for(Object book : arrayList){
            System.out.println(book);
        }
        // 遍历集合
        // 1. 先得到迭代器
        Iterator iterator = arrayList.iterator();
//        while(iterator.hasNext()){
//            Object obj = iterator.next();
//            System.out.println(obj);
//        }
        // itit 快捷键
        // 2. 使用while循环遍历
        while (iterator.hasNext()) {
            Object next = iterator.next();
        }
        // 3. 当退出while循环, iterator指向最后一个元素
        // 4. 如果希望再次遍历, 需要重置迭代器
        iterator = arrayList.iterator();
    }
}
class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}