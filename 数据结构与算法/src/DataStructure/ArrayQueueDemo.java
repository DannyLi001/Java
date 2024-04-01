package DataStructure;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("show");
            System.out.println("exit");
            System.out.println("add");
            System.out.println("get");
            System.out.println("head");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    int val = scanner.nextInt();
                    arrayQueue.addQueue(val);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 'e':
                    loop = false;
                    scanner.close();
                default:
                    break;
            }
        }
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部的前一个位置
        rear = -1; // 指向队列最后一个数据
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("isEmpty");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d", i, arr[i]);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("isEmpty");
        }
        return arr[front + 1];
    }

}