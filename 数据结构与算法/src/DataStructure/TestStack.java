package DataStructure;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("name1");
        stack.add("name2");
        stack.add("name3");

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
