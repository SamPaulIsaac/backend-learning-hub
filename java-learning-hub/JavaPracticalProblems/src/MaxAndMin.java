import java.util.Comparator;
import java.util.List;

public class MaxAndMin {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 5, 1, 3, 2);
        List<Character> charList = List.of('d', 'g', 'a', 'b');
        System.out.println("Min and Max for integers: " + genericSolution(integerList));
        System.out.println("Min and Max for chars: " + genericSolution(charList));
    }

    public static <T extends Comparable<T>> List<T> genericSolution(List<T> elements) {
        T min = elements.stream().min(Comparator.naturalOrder())
                .orElseThrow(() -> new RuntimeException("Unable to find minimum value"));
        T max = elements.stream().max(Comparator.naturalOrder())
                .orElseThrow(() -> new RuntimeException("Unable to find maximum value"));
        return List.of(min, max);
    }
}
