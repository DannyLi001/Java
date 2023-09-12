package com.threaduse;

/**
 * @author
 */
public class Practice03{
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        T0 t0 = new T0();
        Thread thread = new Thread(t0);
        for (int i = 0; i < 10; i++) {
            if(i == 5){
//                t.start();
//                t.join();
                thread.start();
                thread.join();
            }
            System.out.println("hi" + i);
            Thread.sleep(1000);
        }
    }
}
class T extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class T0 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}