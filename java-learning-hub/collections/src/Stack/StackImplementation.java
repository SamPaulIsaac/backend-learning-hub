package Stack;

import java.util.Stack;

public class StackImplementation {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        System.out.println(stack.peek());
    }
}
