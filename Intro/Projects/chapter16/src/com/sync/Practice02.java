package com.sync;

/**
 * @author
 */
public class Practice02 {

    public static void main(String[] args) {
        User1 user1 = new User1();
        Thread thread1 = new Thread(user1);
        Thread thread2 = new Thread(user1);
        thread1.start();
        thread2.start();
    }
}

class User1 implements Runnable {
    private int balance = 1000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (balance <= 0) {
                    break;
                }

                balance -= 100;
                System.out.println(Thread.currentThread().getName() + " " + balance);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
