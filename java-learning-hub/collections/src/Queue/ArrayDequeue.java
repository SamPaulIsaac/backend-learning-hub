package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeue {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("third");
        deque.add("first");
        deque.add("second");
        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
    }
}
