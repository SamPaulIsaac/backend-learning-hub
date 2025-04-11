import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top()); // Should print 3
        System.out.println("Pop: " + stack.pop()); // Should print 3
        System.out.println("Top after pop: " + stack.top()); // Should print 2
        System.out.println("Is empty: " + stack.empty()); // Should print false
        System.out.println("Pop: " + stack.pop()); // Should print 2
        System.out.println("Pop: " + stack.pop()); // Should print 1
        System.out.println("Is empty: " + stack.empty()); // Should print true
    }
}

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        int item = queue1.poll();

        swapQueues();

        return item;
    }

    public int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        int item = queue1.peek();

        queue2.add(queue1.poll());

        swapQueues();

        return item;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    private void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
}
