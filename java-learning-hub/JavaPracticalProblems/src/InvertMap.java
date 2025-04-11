import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> input = Map.of(
                "sam", 29,
                "tom", 34,
                "carter", 31,
                "parkinson", 31);
        Map<Integer, List<String>> invertedMap
                = input.entrySet().stream().collect(Collectors.groupingBy(
                Map.Entry::getValue,
                Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println("Given Map: " + input);
        System.out.println("Inverted Map: " + invertedMap);
    }
}
