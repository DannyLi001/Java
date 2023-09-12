package com.threaduse;

/**
 * @author
 */
public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
// 当一个类继承了Thread类, 该类就可以当作线程使用
// Thread类实现了Runnable接口的run方法
class Cat extends Thread{
    int count;
    @Override
    public void run() { // 重写run方法, 写上自己的业务逻辑
        while (true) {
            System.out.println("sth");
            count ++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 8){
                break;
            }
        }
    }
}