package com.threaduse;

/**
 * @author
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // dog 不能直接调用run
        // 代理模式
        // 创建了Thread对象, 把dog对象(实现Runnable), 放入Thread
        Thread thread = new Thread(dog);
        thread.start();
    }
}



class Dog implements Runnable{
    int count = 0;
    @Override
    public void run() {
        while(true){
            count++;
            System.out.println("Dog" + Thread.currentThread().getName());
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

class Proxy implements Runnable{
    private Runnable target = null;
    @Override
    public void run() {
        if(target != null){
            target.run();
        }
    }

    public void start(){
        start0();
    }
    public void start0(){
        run();
    }

    public Proxy(Runnable target) {
        this.target = target;
    }
}