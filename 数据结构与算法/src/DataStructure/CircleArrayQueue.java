package DataStructure;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("show");
            System.out.println("exit");
            System.out.println("add");
            System.out.println("get");
            System.out.println("head");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    int val = scanner.nextInt();
                    circleArray.addQueue(val);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headQueue();
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

class CircleArray {
    private int maxSize;
    private int front; // 第一个元素index
    private int rear; // 最后一个元素index + 1
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        int i = arr[front];
        front = (front + 1) % maxSize;
        return i;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("isEmpty");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        return arr[front];
    }
}