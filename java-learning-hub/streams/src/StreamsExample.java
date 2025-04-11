import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String[] args) {
        shuffleList();

        intoStreams();

        parallelStreams();

        /*
        Intermediate operation -

        Terminal operation - collect, sum, foreach,
         */

        filterOperation();

        mapAndCollect();

        flatMapAndCollect();

        findFirstAndOptional();

        reduceAndSum();


    }

    private static void parallelStreams() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        System.out.println("Printing list items through parallel stream: ");
        list.parallelStream().forEach(System.out::println);
        System.out.println("----------------------------------------------------");


        List<String> listForTestingForEachOrdered = Arrays.asList("z", "e", "a", "b", "c", "d");
        System.out.println("Printing list items through parallel stream list2: ");
        listForTestingForEachOrdered.parallelStream().forEachOrdered(System.out::println);
        System.out.println("----------------------------------------------------");


    }

    private static void terminalOperations() {
    }

    private static void intermediateOperations() {

    }

    private static void intoStreams() {
        List<String> strings = new ArrayList<>();
        strings.add("Apple");
        strings.add("Banana");
        strings.add("Cherry");
        strings.add("Date");

        Stream<List<String>> stringStream = Stream.of(strings);
        System.out.println("Streams - iterator has next?: " + stringStream.iterator().hasNext());
        System.out.println("----------------------------------------------------");
    }

    private static void reduceAndSum() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("The result of reduce and sum is: " + sum);
        System.out.println("----------------------------------------------------");
    }

    private static void findFirstAndOptional() {
        // Find first and optional
        List<String> strings = List.of("banana", "apple", "cherry", "date");
        String result = strings.stream().filter(a -> a.startsWith("a") || a.startsWith("A")).findFirst().orElse("Not Found");
        System.out.println("The result of findFirst and optional: " + result);
        System.out.println("----------------------------------------------------");

    }

    private static void flatMapAndCollect() {
        //FlatMap and Collect
        List<List<Integer>> listOfLists = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6, 7, 8, 9));
        List<Integer> result = listOfLists.stream().flatMap(Collection::stream).peek(System.out::println).toList();
        System.out.println("The result of flat map is: " + result);
        System.out.println("----------------------------------------------------");

    }

    private static void mapAndCollect() {
        //Map and collect
        List<String> stringList = List.of("apple", "banana", "cherry", "date");
        List<String> resultStrings = stringList.stream().map(String::toUpperCase).toList();
        System.out.println("The result after map processing: " + resultStrings);
        System.out.println("----------------------------------------------------");
    }

    private static void filterOperation() {
        // Intermediate operations: - it converts to another stream -pipeline of operation
        // Terminate operations - returns a result.
        List<String> strings = List.of("michael", "paul", "jordan", "bryant");
        String result = strings.stream().filter(a -> a.matches(".*[aeiouAEIOU].*")).collect(Collectors.joining(","));
        System.out.println(result);
        System.out.println("----------------------------------------------------");

        // Filter and collect
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> oddIntegers = integers.stream().filter(i -> i % 2 != 0).toList();
        System.out.println("The result after filtering: " + oddIntegers);
        System.out.println("----------------------------------------------------");
    }

    private static void shuffleList() {
        List<String> strings = new ArrayList<>();
        strings.add("Apple");
        strings.add("Banana");
        strings.add("Cherry");
        strings.add("Date");
        strings.add("Elderberry");
        strings.add("Fig");
        strings.add("Grape");
        strings.add("Honeydew");
        strings.add("Kiwi");
        strings.add("Lemon");
        System.out.println("Before shuffling: " + strings);
        Collections.shuffle(strings);
        System.out.println("After shuffling: " + strings);
        System.out.println("----------------------------------------------------");
    }
}
