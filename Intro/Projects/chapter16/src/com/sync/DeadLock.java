package com.sync;

/**
 * @author
 */
public class DeadLock {
    public static void main(String[] args) {
        DeadLockDemo deadLockDemo1 = new DeadLockDemo(true);
        DeadLockDemo deadLockDemo2 = new DeadLockDemo(false);
        deadLockDemo1.start();
        deadLockDemo2.start();
    }
}
class DeadLockDemo extends Thread{
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1){
                System.out.println(Thread.currentThread().getName());
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }else{
            synchronized (o2){
                System.out.println(Thread.currentThread().getName());
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }
    }
}