package com.threadexit;

/**
 * @author
 */
public class ThreadInter {
    public static void main(String[] args) {
        T1 t1 = new T1();
//        t1.setName("name");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("hi");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        t1.interrupt();


    }
}
class T1 extends Thread{
    @Override
    public void run() {
        while(true){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName());
                if(i == 5){
                    Thread.yield();
                }
            }
            try {
                System.out.println("sleep");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }
}