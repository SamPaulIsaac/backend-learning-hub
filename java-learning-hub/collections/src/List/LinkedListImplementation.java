package List;

import java.util.LinkedList;
import java.util.List;

public class LinkedListImplementation {

    public static void main(String[] args) {
        LinkedList<String> sampleFruits = new LinkedList<>();
        sampleFruits.add("Green Apple");
        sampleFruits.add("Kashmir Apple");
        LinkedList<String> fruits = new LinkedList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Pineapple");
        fruits.addAll(sampleFruits);
        fruits.addAll(1, sampleFruits);
        fruits.addFirst("First Apple");
        fruits.addLast("Last Apple");
        System.out.println("Sub List: " + fruits.subList(2, fruits.size()));
        fruits.forEach(System.out::println);
        System.out.println("Size: " + fruits.size());
        List<String> sortedArray = fruits.stream().sorted().toList();
        System.out.println("Sorted Array: " + sortedArray);
        System.out.println("GET: " + sortedArray.get(0));
    }
}
