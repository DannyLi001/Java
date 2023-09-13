package com.threaduse;

/**
 * @author
 */
public class Practice02 {
    public static void main(String[] args) {
//        SellTicket sellTicket1 = new SellTicket();
//        SellTicket sellTicket2 = new SellTicket();
//        SellTicket sellTicket3 = new SellTicket();
//        sellTicket1.start();
//        sellTicket2.start();
//        sellTicket3.start();
        SellTicket01 sellTicket01 = new SellTicket01();
        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();
    }
}

class SellTicket extends Thread{
    private static int ticketNum = 100;
    @Override
    public void run() {
        while(true){
            if(ticketNum <= 0){
                System.out.println("finish");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + ticketNum--);
        }
    }
}

class SellTicket01 implements Runnable{
    private int ticketNum = 100;
    @Override
    public void run() {
        while(true) {
            if (ticketNum <= 0) {
                System.out.println("finish");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + ticketNum--);
        }
    }
}