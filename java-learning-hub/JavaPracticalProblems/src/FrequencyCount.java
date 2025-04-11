import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyCount {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 5, 1, 3, 2);
        Map<Integer, Integer> firstSolution = new HashMap<>();
        for (Integer integer : integerList)
            firstSolution.put(integer, firstSolution.getOrDefault(integer, 0) + 1);
        System.out.println("Frequency count using first approach: " + firstSolution);


        Map<Integer, Long> secondSolution = integerList.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println("Frequency count using second approach: " + secondSolution);

        List<Character> characterArrayList = List.of('s', 'a', 'b', 'a', 'd', 's');
        System.out.println("Frequency count using third approach(characters): " + genericSolution(characterArrayList));
        System.out.println("Frequency count using third approach(integers): " + genericSolution(integerList));
    }

    public static <T> Map<T, Long> genericSolution(List<T> list) {
        return list.stream()
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()));
    }
}
