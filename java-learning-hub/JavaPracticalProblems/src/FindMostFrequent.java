import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindMostFrequent {
    public static void main(String[] args) {
        List<String> words = List.of("banana", "apple", "cherry", "banana", "apple");

        Map<String, Integer> map = new HashMap<>();
        for (String s : words)
            map.put(s, map.getOrDefault(s, 0) + 1);
        System.out.println("Map: " + map);
        System.out.println("MAX occurrence: " + map.values().stream().max(Comparator.naturalOrder()).get());
        System.out.println("Most frequent occurrence: " + map.entrySet()
                .stream()
                .filter(a -> a.getValue() >=
                        map.values().stream().max(Comparator.naturalOrder()).get())
                .toList());

    }
}
