package com.sync;

import java.util.Scanner;

/**
 * @author
 */
public class Practice01 {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread thread = new Thread(thread1);
        thread.start();

        Thread2 thread2 = new Thread2(thread1);
        thread2.start();
    }
}

class Thread1 implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        while(flag){
            System.out.println((int)(Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class Thread2 extends Thread{
    private Thread1 t1;

    public Thread2(Thread1 t1) {
        this.t1 = t1;
    }

    Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        while(true){
            char input = scanner.next().charAt(0);
            if(input == 'q'){
                t1.setFlag(false);
                break;
            }
        }
    }
}