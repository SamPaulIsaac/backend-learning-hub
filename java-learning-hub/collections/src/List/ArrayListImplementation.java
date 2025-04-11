package List;


import java.util.ArrayList;
import java.util.List;

public class ArrayListImplementation {
    /* Methods
        1. add, size, get, getFirst, getLast, stream, parallel stream, foreach, map, filter, sort,
        sorted comparator, for

    */
    public static void main(String[] args) {
        List<String> sampleFruits = new ArrayList<>();
        sampleFruits.add("Green Apple");
        sampleFruits.add("Kashmir Apple");
        List<String> fruits = new ArrayList<>();
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
