package DataStructure;

public class Calculator {
    public static void main(String[] args) {
        String exp = "31+2*60-2";
        ArrayStack2 numbers = new ArrayStack2(10);
        ArrayStack2 operators = new ArrayStack2(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";

        while (true) {
            ch = exp.substring(index, index + 1).charAt(0);
            if (operators.isOper(ch)) {
                if (operators.isEmpty()) {
                    operators.push(ch);
                } else {
                    if (operators.priority(ch) <= operators.priority(operators.peek())) {
                        num1 = numbers.pop();
                        num2 = numbers.pop();
                        oper = operators.pop();

                        res = numbers.cal(num1, num2, oper);
                        numbers.push(res);
                        operators.push(ch);
                    } else {
                        operators.push(ch);
                    }
                }
            } else {
                keepNum += ch;

                if (index == exp.length() - 1) {
                    numbers.push(Integer.parseInt(keepNum));
                } else {
                    if (operators.isOper(exp.substring(index + 1, index + 2).charAt(0))) {
                        numbers.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= exp.length()) {
                break;
            }
        }
        while (true) {
            if (operators.isEmpty()) {
                break;
            }
            num1 = numbers.pop();
            num2 = numbers.pop();
            oper = operators.pop();

            res = numbers.cal(num1, num2, oper);
            numbers.push(res);
        }
        System.out.println(numbers.pop());
    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
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

    public int peek() {
        return stack[top];
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

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}