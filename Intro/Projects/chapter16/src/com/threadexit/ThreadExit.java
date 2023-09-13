package com.threadexit;

/**
 * @author
 */
public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        // main线程控制t线程
        // 修改loop, 让t退出run方法 -> 通知方式
        Thread.sleep(1000 * 10);
        t.setLoop(false);
    }
}

class T extends Thread {
    private int count;
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count++);
        }
    }
}