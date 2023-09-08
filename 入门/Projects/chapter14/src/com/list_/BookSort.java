package com.list_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class BookSort {

    public static void main(String[] args) {
        Book book1 = new Book("book1", 10, "author1");
        Book book2 = new Book("book2", 21, "author2");
        Book book3 = new Book("book3", 12, "author3");
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add(book1);
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book)o1;
                Book b2 = (Book)o2;
                return (int)(b1.getPrice() - b2.getPrice());
            }
        });
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}

class Book{
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }
}