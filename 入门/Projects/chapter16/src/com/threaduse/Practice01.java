package com.threaduse;

/**
 * @author
 */
public class Practice01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        Thread thread = new Thread(t1);
        thread.start();
        T2 t2 = new T2();
        t2.start();
    }
}

class T1 implements Runnable{
    int count;
    @Override
    public void run() {
        while (true) {
            count++;
            System.out.println("hello world"+ Thread.currentThread().getName());
            if(count == 10){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class T2 extends Thread{
    int count;
    @Override
    public void run() {
        while(true){
            count++;
            System.out.println("t2" + Thread.currentThread().getName());
            if(count == 20){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}