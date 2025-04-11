package Queue;

import java.util.Comparator;

public class PriorityQueue {
    public static void main(String[] args) {
        Comparator<String> comparator = Comparator.comparingInt(String::length);

        java.util.PriorityQueue<String> priorityQueue = new java.util.PriorityQueue<>(comparator);
        priorityQueue.add("apple");
        priorityQueue.add("banana");
        priorityQueue.add("cherry");
        priorityQueue.add("jack fruit");
        priorityQueue.add("fig");
        priorityQueue.add("dry");
        priorityQueue.add("pine apple");

        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.poll());

    }
}
