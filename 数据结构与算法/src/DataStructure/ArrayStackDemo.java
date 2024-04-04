package DataStructure;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(4);
        String key = "";
        boolean flag = true;
        Scanner myScanner = new Scanner(System.in);

        while (flag) {
            System.out.println("show");
            System.out.println("exit");
            System.out.println("push");
            System.out.println("pop");

            key = myScanner.next();
            switch (key) {
                case "show":
                as.show();
                    break;
                case "exit":
                    myScanner.close();
                    flag = false;
                    break;
                case "push":
                    int val = myScanner.nextInt();
                    as.push(val);
                    break;
                case "pop":
                    try {
                        int res = as.pop();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        return stack[top--];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("isEmpty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}