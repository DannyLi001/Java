package com;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author
 */
public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘20年", 5);
        books[3] = new Book("java从入门到放弃", 300);

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return b1.getPrice() - b2.getPrice();
            }
        });
        System.out.println(Arrays.toString(books));

        Book.bubbleSort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return b1.getName().length() - b2.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));

    }
}
class Book{
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public static void bubbleSort(Book[] books, Comparator c){
        Book tmp;
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if(c.compare(books[j],books[j+1]) > 0){
                    tmp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = tmp;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}