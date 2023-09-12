package com.threadexit;

/**
 * @author
 */
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        T3 t3 = new T3();
        Thread thread = new Thread(t3);
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main");
            Thread.sleep(1000);
        }
    }
}
class T3 implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}