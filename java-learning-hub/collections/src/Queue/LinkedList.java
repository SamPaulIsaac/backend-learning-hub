package Queue;

import java.util.Queue;

public class LinkedList {
    public static void main(String[] args) {

        Queue<String> queue = new java.util.LinkedList<>();
        queue.add("third");
        queue.add("second");
        queue.add("first");
        while (!queue.isEmpty())
            System.out.println(queue.poll());
    }
}
